package com.example.eventer.repos;

import com.example.eventer.entity.Sequence;
import com.example.eventer.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
    Optional<Team> findByTeamID(Long id);
}
