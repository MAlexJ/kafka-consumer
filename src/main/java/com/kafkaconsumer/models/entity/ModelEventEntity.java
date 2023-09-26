package com.kafkaconsumer.models.entity;

import com.kafkaconsumer.models.event.Event;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(value = "eventSchema")
public class ModelEventEntity {
    private String id;
    private Event event;
    private String message;
    private String scheduler;
    private LocalDateTime created;
}
