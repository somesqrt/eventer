package com.example.eventer.services.services;

import com.example.eventer.dao.request.TeamCreateRequest;
import com.example.eventer.entity.Team;

import java.util.Optional;

public interface TeamService {
    Team addTeam(TeamCreateRequest request);

    Optional<Team> getTeam(String teamId);
}
