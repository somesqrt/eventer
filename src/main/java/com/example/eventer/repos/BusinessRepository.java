package com.example.eventer.repos;
import com.example.eventer.entity.Business;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepository extends MongoRepository<Business, Long> {
    Optional<Business> findByName(String name);

    Optional<Business> findByBusinessID(Long id);

    List<Business> findByOwner(String owner);

}
