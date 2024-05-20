package br.com.bandao.ProducerExemple.controller.Object;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bandao.ProducerExemple.dto.PostObjectMessageDTO;
import br.com.bandao.ProducerExemple.dto.PutObjectMessageDTO;
import br.com.bandao.ProducerExemple.model.ObjectMessage;
import br.com.bandao.ProducerExemple.service.Object.ObjectMessageService;
import br.com.bandao.ProducerExemple.service.message.MessageService;

@RestController
@RequestMapping("/objects")
public class ObjectController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ObjectMessageService objectMessageService;

    @PostMapping
    public void createObject(@RequestBody PostObjectMessageDTO objectDTO) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(objectDTO);
        messageService.sendMessage(message);
    }

    @PutMapping("/{id}")
    public void updateObject(@PathVariable Long id, @RequestBody PutObjectMessageDTO objectDTO)
            throws JsonProcessingException {
        objectDTO.setId(id);
        String message = objectMapper.writeValueAsString(objectDTO);
        messageService.sendMessage(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectMessage> getById(@PathVariable Long id) {
        Optional<ObjectMessage> objectMessage = objectMessageService.getById(id);
        if (objectMessage.isPresent()) {
            return ResponseEntity.ok(objectMessage.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ObjectMessage>> getAll() {
        List<ObjectMessage> objectMessages = objectMessageService.getAll();
        return ResponseEntity.ok(objectMessages);
    }

}
