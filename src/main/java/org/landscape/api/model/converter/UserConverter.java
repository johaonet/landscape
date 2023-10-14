package org.landscape.api.model.converter;

import org.landscape.api.model.dto.UserDto;
import org.landscape.api.model.entity.UserEntity;
import org.landscape.api.model.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class 

UserConverter {
    public UserDto toDto(UserEntity entity) {
        if (entity == null) {
            return null;
        } else {
            return UserDto.builder()
                    .id(entity.getId())
                    .email(entity.getEmail())
                    .fullName(entity.getFullName())
                    .password(entity.getPassword())
                    .build();
        }
    }

    public UserEntity toEntity(UserRequest request) {
        if (request == null) {
            return null;
        } else {
            return UserEntity.builder()
                    .id(request.getId())
                    .email(request.getEmail())
                    .fullName(request.getFullName())
                    .password(request.getPassword())
                    .build();
        }
    }
    

}
