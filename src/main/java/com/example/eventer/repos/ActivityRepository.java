package com.example.eventer.repos;

import com.example.eventer.entity.Business;
import com.example.eventer.entity.TypeOfActivity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends MongoRepository<TypeOfActivity, String> {
    Optional<TypeOfActivity> findByBusinessIDAndNameOfActivity(Long businessID, String nameOfActivity);

}
