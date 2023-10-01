package com.kafkaconsumer.services;

import com.kafkaconsumer.models.entity.ErrorEventEntity;
import com.kafkaconsumer.models.entity.ModelEventEntity;
import com.kafkaconsumer.models.event.Event;
import com.kafkaconsumer.repository.ErrorEventRepository;
import com.kafkaconsumer.repository.ModelEventRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
class KafkaServiceImpl {

    private static final String SCHEDULER_NAME = "KafkaListener";
    private final ModelEventRepository modelEventRepository;
    private final ErrorEventRepository errorEventRepository;


    @Timed
    @KafkaListener(topics = "${cloud.kafka.topic}")
    public void processMessage(String message, //
                               @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions, //
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics, //
                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        errorHandler(message, () -> {
            log.info("topic:{}, partition:{}, offset: {}, message: {}", topics, partitions, offsets, message);
            ModelEventEntity entity = saveEntity(message);
            log.info("Entity with id - [{}] was successfully saved to the database ", entity.getId());
        });
    }

    @Timed("save-mangoDb")
    private ModelEventEntity saveEntity(String message) {
        return modelEventRepository.save(buildModelEventEntity(message));
    }


    private ModelEventEntity buildModelEventEntity(String message) {
        return ModelEventEntity //
                .builder() //
                .id(UUID.randomUUID().toString()) //
                .event(Event.KAFKA_EVENT) //
                .message(message) //
                .scheduler(SCHEDULER_NAME) //
                .created(LocalDateTime.now()) //
                .build();
    }


    private void errorHandler(String message, Runnable r) {
        try {
            r.run();
        } catch (Exception ex) {
            String errorMessage = String.format("Can't process message - [%s], error - %s", message, ex.getMessage());
            saveError(message, errorMessage);
        }
    }

    @Timed
    @Counted
    private void saveError(String message, String errorMessage) {
        errorEventRepository.save(buildErrorEntity(errorMessage, message));
    }


    private ErrorEventEntity buildErrorEntity(String errorMessage, String kafkaMessage) {
        log.warn(errorMessage);
        return ErrorEventEntity.builder() //
                .errorMessage(errorMessage) //
                .message(kafkaMessage) //
                .data(LocalDateTime.now()) //
                .build();
    }

}