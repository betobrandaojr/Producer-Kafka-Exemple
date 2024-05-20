package br.com.bandao.ProducerExemple.controller.Object;

import br.com.bandao.ProducerExemple.dto.ObjectMessageDTO;
import br.com.bandao.ProducerExemple.service.message.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/objects")
public class ObjectController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public void createObject(@RequestBody ObjectMessageDTO objectDTO) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(objectDTO);
        messageService.sendMessage(message);
    }
}
