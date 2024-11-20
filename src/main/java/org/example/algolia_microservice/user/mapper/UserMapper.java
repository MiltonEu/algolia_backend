package org.example.algolia_microservice.user.mapper;

import org.example.algolia_microservice.indexer.model.IndexableUser;
import org.example.algolia_microservice.user.dto.UserResponseDTO;
import org.example.algolia_microservice.user.model.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToEntity(UserResponseDTO userDTO);
    IndexableUser mapToIndexableUser(User user);
    UserResponseDTO mapToUserResponseDTO(User user);
}
