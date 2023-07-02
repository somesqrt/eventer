package com.example.eventer.repos;

import com.example.eventer.entity.Sequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequenceRepository extends MongoRepository<Sequence, String> {
    Optional<Sequence> findById(String id);
}