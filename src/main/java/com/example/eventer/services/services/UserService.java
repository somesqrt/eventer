package com.example.eventer.services.services;

import com.example.eventer.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    User getUserByEmail(String email);
    List<User> getTeamMembers(String teamID);
}