package com.example.eventer.repos;

import com.example.eventer.entity.Client;
import com.example.eventer.entity.Sequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, Long> {

    Optional<Client> findByClientId(Long id);
}
