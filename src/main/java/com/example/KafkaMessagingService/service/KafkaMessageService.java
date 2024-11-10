package com.example.KafkaMessagingService.service;

import java.util.UUID;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.KafkaMessagingService.pojo.MessageRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaMessageService {
    
    @Value("${spring.kafka.producer.topic}")
    private String topic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String payload, String source) {
        MessageRecord message = new MessageRecord(
            UUID.randomUUID().toString(),
            payload,
            source,
            Instant.now()
        );
        try {
            String response = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(topic, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
