package br.com.bandao.ProducerExemple.service.Object;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bandao.ProducerExemple.repository.ObjectRepository;
import br.com.bandao.ProducerExemple.dto.ObjectMessageDTO;
import br.com.bandao.ProducerExemple.model.ObjectMessage;

import br.com.bandao.ProducerExemple.service.message.MessageService;

@Service
public class ObjectMessageService {

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;
    
    // metod "save"
    public void save(ObjectMessageDTO dto) {
        try {
            ObjectMessage obj = convertDtoToEntity(dto);
            String message = objectMapper.writeValueAsString(obj);
            messageService.sendMessage(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        } catch (Exception e) {
            throw new RuntimeException("Error sending object to Kafka", e);
        }
    }

    // metod "update"
    public void update(Long id, ObjectMessageDTO dto) {
        try {
            Optional<ObjectMessage> existingObject = objectRepository.findById(id);
            if (existingObject.isPresent()) {
                ObjectMessage updatedObject = existingObject.get();
                updatedObject.setName(dto.getName());
                String message = objectMapper.writeValueAsString(updatedObject);
                messageService.sendMessage(message);
            } else {
                throw new RuntimeException("Object not found");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting object to JSON", e);
        } catch (Exception e) {
            throw new RuntimeException("Error sending object to Kafka", e);
        }
    }

    // metod "getById"
    public Optional<ObjectMessage> getById(Long id) {
        try {
            return this.objectRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting ObjectMessage by id", e);
        }
    }

    // metod "getAll"
    public List<ObjectMessage> getAll() {
        try {
            return this.objectRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all objects", e);
        }
    }

    // convert dto to entity
    private ObjectMessage convertDtoToEntity(ObjectMessageDTO dto) {
        ObjectMessage obj = new ObjectMessage();
        obj.setName(dto.getName());
        return obj;
    }
}