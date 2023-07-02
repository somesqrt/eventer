package com.example.eventer.services.impl.authImpl;

import com.example.eventer.dao.request.SignUpRequest;
import com.example.eventer.dao.request.SigninRequest;
import com.example.eventer.dao.responce.JwtAuthenticationResponse;
import com.example.eventer.entity.Role;
import com.example.eventer.entity.User;
import com.example.eventer.repos.UserRepository;
import com.example.eventer.services.services.auth.AuthenticationService;
import com.example.eventer.services.services.IdGeneratorService;
import com.example.eventer.services.services.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final IdGeneratorService idGeneratorService;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User with the same email already exists.");
        }

        var user = User.builder()
                .userId(idGeneratorService.generateNextId("user"))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_ADMIN)
                .phone(request.getPhone())
                .active(false)
                .build();

        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        System.out.println(user.toString());
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}