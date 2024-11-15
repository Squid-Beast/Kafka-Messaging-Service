package com.example.KafkaMessagingService.pojo;

import org.apache.kafka.common.protocol.types.Field.Str;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    private String status;
    private String message;

    public Response(String status) {
        this.status = status;
    }
    public Response(String status,String message) {
        this.status = status;
        this.message = message;
    }
}
