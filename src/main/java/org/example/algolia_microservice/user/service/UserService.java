package org.example.algolia_microservice.user.service;

import org.example.algolia_microservice.user.dto.UserResponseDTO;

public interface UserService {
    void deleteAllUsers();
    void createUser(UserResponseDTO userDTO);
}
