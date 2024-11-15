package com.example.KafkaMessagingService.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.KafkaMessagingService.pojo.MessageRecord;
import com.example.KafkaMessagingService.pojo.Response;
import com.example.KafkaMessagingService.service.KafkaMessageService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaMessageService kafkaMessageService;

    @PostMapping("/publish")
    public ResponseEntity<Response> sendMessage(@RequestBody MessageRecord messageRecord) {
        kafkaMessageService.sendMessage(messageRecord.getPayload(), messageRecord.getSource());
        return new ResponseEntity<>(new Response("Success","Message sent to Kafka."), HttpStatus.OK);
    }
    
    @GetMapping("/consume")
    public ResponseEntity<Response> consumeMessage() {
        List<MessageRecord> messages = kafkaMessageService.getConsumedMessages();
        if (messages.isEmpty()) {
            return new ResponseEntity<>(new Response("No Messages", "No messages found in Kafka."), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Success", messages.toString()), HttpStatus.OK);
    }
}
