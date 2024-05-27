package com.example.demo.KafkaConfig;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME = "user-action"; 

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String user, String message) {
        kafkaTemplate.send(TOPIC_NAME, user, message);
        System.out.println("Message " + message
                + " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }

}
