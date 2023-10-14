package org.landscape.api.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.landscape.api.model.dto.UserPermissionDto;
import org.landscape.api.model.entity.PermissionEntity;
import org.landscape.api.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionConverter {

    PermissionConverter permissionConverter = new PermissionConverter();

    public UserPermissionDto toDto(UserEntity userEntity, List<PermissionEntity> permissionsEntity) {
        if (userEntity == null || permissionsEntity == null) {
            return null;
        } else {
            return UserPermissionDto.builder()
                    .id(userEntity.getId())
                    .email(userEntity.getEmail())
                    .fullName(userEntity.getFullName())
                    .permissions(
                        permissionsEntity.stream()
                        .map(permissionConverter::toDto)
                        .collect(Collectors.toList())
                    )
                    .build();
        }
    }
}
