package com.example.eventer.controller;

import com.example.eventer.dao.request.TeamCreateRequest;
import com.example.eventer.entity.Event;
import com.example.eventer.entity.Team;
import com.example.eventer.entity.User;
import com.example.eventer.services.services.TeamService;
import com.example.eventer.services.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getByEmail")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'EMPLOY')")
    public ResponseEntity<User> getAllEvents(@RequestParam("email") String email) {
        System.out.println(email);
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

}
