package br.com.bandao.ProducerExemple.controller.Object;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.bandao.ProducerExemple.service.message.MessageService;

@RestController
@RequestMapping("/objects")
public class ObjectController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

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
    public ObjectMessage getObject(@PathVariable Long id) {
        return new ObjectMessage();
    }

    @GetMapping("List")
    public ObjectMessage getObjectList() {
        return new ObjectMessage();
    }

}
