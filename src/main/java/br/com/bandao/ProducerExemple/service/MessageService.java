package br.com.bandao.ProducerExemple.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.exemple-kafka}")
    private String topicName;

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(topicName, message);
    }

}
