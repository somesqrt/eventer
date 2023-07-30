package com.example.eventer.services.impl;

import com.example.eventer.entity.Team;
import com.example.eventer.entity.User;
import com.example.eventer.repos.TeamRepository;
import com.example.eventer.repos.UserRepository;
import com.example.eventer.services.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    @Override
    public List<User> getTeamMembers(String teamID) {
        Optional<Team> existingTeam = teamRepository.findByTeamID(Long.parseLong(teamID));
        if (existingTeam.isEmpty()) {
            throw new IllegalArgumentException("Team with that ID dosent exists.");
        }

        String[] teamMembers = existingTeam.get().getTeamMembers();
        List<User> userList = new ArrayList<>();

        for(int i = 0; i < teamMembers.length; i++) {
            Optional<User> user = userRepository.findByUserId(Long.parseLong(teamMembers[i]));
            user.ifPresent(newUser -> {
                userList.add(newUser);
            });
        }

        return userList;
    }
}