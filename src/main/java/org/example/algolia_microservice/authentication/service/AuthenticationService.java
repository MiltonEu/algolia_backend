package org.example.algolia_microservice.authentication.service;


import org.example.algolia_microservice.authentication.dto.AuthRequest;
import org.example.algolia_microservice.user.model.User;
import org.example.algolia_microservice.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(AuthRequest input) {
        User user = new User(
                null,
                null,
                null,
                input.getEmail(),
                passwordEncoder.encode(input.getPassword()),
                Instant.now(),
                Instant.now(),
                null
        );

        return userRepository.save(user);
    }

    public User authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );

        return userRepository.findByEmail(authRequest.getEmail())
                .orElseThrow();
    }
}
