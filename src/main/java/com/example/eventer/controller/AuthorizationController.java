package com.example.eventer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthorizationController {
    @GetMapping("/hi")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hi user");
    }


}