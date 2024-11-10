package com.example.KafkaMessagingService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return new ResponseEntity<>(new Response("success"), HttpStatus.OK);
    }
    
}
