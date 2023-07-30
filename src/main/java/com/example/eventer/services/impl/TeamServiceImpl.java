package com.example.eventer.services.impl;

import com.example.eventer.dao.request.TeamCreateRequest;
import com.example.eventer.entity.Team;
import com.example.eventer.repos.TeamRepository;
import com.example.eventer.services.services.IdGeneratorService;
import com.example.eventer.services.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final IdGeneratorService idGeneratorService;


    @Override
    public Team addTeam(TeamCreateRequest request) {
        var existingTeam = teamRepository.findByTeamID(idGeneratorService.giveNextId("team"));
        if (existingTeam.isPresent()) {
            throw new IllegalArgumentException("Team with the same ID already exists.");
        }

        var team = Team.builder()
                .teamID(idGeneratorService.generateNextId("team"))
                .teamMembers(request.getTeamMembers())
                .memberCount(String.valueOf(request.getTeamMembers().length))
                .build();

        teamRepository.save(team);
        return team;
    }

    @Override
    public Optional<Team> getTeam(String teamId) {
        var existingTeam = teamRepository.findByTeamID(Long.parseLong(teamId));
        if (existingTeam.isEmpty()) {
            throw new IllegalArgumentException("Team with ID dosent exists.");
        }

        return existingTeam;
    }
}
