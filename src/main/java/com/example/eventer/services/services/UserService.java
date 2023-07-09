package com.example.eventer.services.services;

import com.example.eventer.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();

    User getUserByEmail(String email);


}