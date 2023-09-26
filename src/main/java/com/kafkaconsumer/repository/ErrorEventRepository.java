package com.kafkaconsumer.repository;

import com.kafkaconsumer.models.entity.ErrorEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorEventRepository extends MongoRepository<ErrorEventEntity, String> {
}
