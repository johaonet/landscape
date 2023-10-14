package org.landscape.api.model.converter;

import org.landscape.api.model.dto.PermissionDto;
import org.landscape.api.model.entity.PermissionEntity;
import org.landscape.api.model.request.PermissionRequest;
import org.springframework.stereotype.Component;

@Component
public class PermissionConverter {
    public PermissionDto toDto(PermissionEntity entity) {
        if (entity == null) {
            return null;
        } else {
            return PermissionDto.builder()
                    .id(entity.getId())
                    .userId(entity.getUserId())
                    .permission(entity.getPermission())
                    .build();
        }
    }

    public PermissionEntity toEntity(PermissionRequest request) {
        if (request == null) {
            return null;
        } else {
            return PermissionEntity.builder()
                    .id(request.getId())
                    .userId(request.getUserId())
                    .permission(request.getPermission())
                    .build();
        }
    }

}
