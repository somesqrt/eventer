package com.example.eventer.repos;

import com.example.eventer.entity.Business;
import com.example.eventer.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, Long> {

    Optional<Event> findByEventID(Long eventId);

    List<Event> findByBusinessID(String businessID);

}
