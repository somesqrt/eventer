package com.example.eventer.services.services.auth;

import com.example.eventer.dao.request.SignUpRequest;
import com.example.eventer.dao.request.SigninRequest;
import com.example.eventer.dao.responce.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}