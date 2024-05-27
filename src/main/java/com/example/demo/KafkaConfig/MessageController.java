package com.example.demo.KafkaConfig;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final Producer kafkaProducer;

    public MessageController(Producer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

}