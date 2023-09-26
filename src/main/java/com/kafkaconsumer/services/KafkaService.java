package com.kafkaconsumer.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
class KafkaService {

    @KafkaListener(topics = "${cloud.kafka.topic}")
    public void processMessage(String message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.printf(">>> topic: %s, partition: %d, offset: %d, message : \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
    }

}