package org.example.algolia_microservice.authentication.controller;

import org.example.algolia_microservice.authentication.dto.AuthRequest;
import org.example.algolia_microservice.authentication.service.AuthenticationService;
import org.example.algolia_microservice.authentication.service.JwtService;
import org.example.algolia_microservice.authentication.dto.AuthResponse;
import org.example.algolia_microservice.user.dto.UserResponseDTO;
import org.example.algolia_microservice.user.mapper.UserMapper;
import org.example.algolia_microservice.user.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    private final UserMapper userMapper;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, UserMapper userMapper) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> register(@RequestBody AuthRequest authRequest) {
        User registeredUser = authenticationService.signup(authRequest);
        UserResponseDTO userDTO = userMapper.mapToUserResponseDTO(registeredUser);

        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        User authenticatedUser = authenticationService.authenticate(authRequest);

        AuthResponse authResponse = jwtService.generateTokens(authenticatedUser);

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/profileFromToken")
    public ResponseEntity<UserResponseDTO> refreshToken(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(userMapper.mapToUserResponseDTO(user));

    }
}
