package com.example.eventer.controller;

import com.example.eventer.dao.request.TeamCreateRequest;
import com.example.eventer.entity.Team;
import com.example.eventer.services.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<Team> saveTeam(@RequestBody TeamCreateRequest request) {
        return ResponseEntity.ok(teamService.addTeam(request));
    }

    @GetMapping("/getTeam")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<Optional<Team>> getTeam(@RequestParam String teamId) {
        return ResponseEntity.ok(teamService.getTeam(teamId));
    }
}
