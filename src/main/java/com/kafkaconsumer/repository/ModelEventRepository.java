package com.kafkaconsumer.repository;


import com.kafkaconsumer.models.entity.ModelEventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ModelEventRepository extends MongoRepository<ModelEventEntity, String> {
    Page<ModelEventEntity> findAll(Pageable pageable);

}
