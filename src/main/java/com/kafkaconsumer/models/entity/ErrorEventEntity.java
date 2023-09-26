package com.kafkaconsumer.models.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(value = "errorSchema")
public class ErrorEventEntity {
    private String id;
    private String message;
    private String errorMessage;
    private LocalDateTime data;
}
