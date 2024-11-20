package org.example.algolia_microservice.user.service;

import org.example.algolia_microservice.user.dto.UserResponseDTO;
import org.example.algolia_microservice.user.mapper.UserMapper;
import org.example.algolia_microservice.user.model.User;
import org.example.algolia_microservice.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public void createUser(UserResponseDTO userDTO) {
        User user = userMapper.mapToEntity(userDTO);
        userRepository.save(user);
    }
}
