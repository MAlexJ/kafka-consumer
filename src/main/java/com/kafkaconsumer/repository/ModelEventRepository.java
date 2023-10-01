package com.kafkaconsumer.repository;


import com.kafkaconsumer.models.entity.ModelEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ModelEventRepository extends MongoRepository<ModelEventEntity, String> {

}
