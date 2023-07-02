package com.example.eventer.services.services;

import com.example.eventer.dao.request.TeamCreateRequest;
import com.example.eventer.entity.Team;

public interface TeamService {
    Team addTeam(TeamCreateRequest request);
}
