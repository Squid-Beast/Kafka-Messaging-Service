package com.example.KafkaMessagingService.pojo;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class MessageRecord {
    private String id;
    private String payload;
    private String source;
    private Instant timestamp;
}
