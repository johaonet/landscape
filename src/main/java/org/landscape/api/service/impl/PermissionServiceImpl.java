package org.landscape.api.service.impl;

import org.landscape.api.model.converter.PermissionConverter;
import org.landscape.api.model.dto.PermissionDto;
import org.landscape.api.model.entity.PermissionEntity;
import org.landscape.api.model.request.PermissionRequest;
import org.landscape.api.model.response.PermissionDeleteResponse;
import org.landscape.api.model.response.PermissionListResponse;
import org.landscape.api.model.response.UserListResponse;
import org.landscape.api.repository.PermissionRepository;
import org.landscape.api.service.PermissionService;
import org.landscape.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final UserService userService;
    private final PermissionConverter permissionConverter;

    public PermissionServiceImpl(PermissionRepository permissionRepository, PermissionConverter permissionConverter, UserService userService) {
        this.permissionRepository = permissionRepository;
        this.permissionConverter = permissionConverter;
        this.userService = userService;
    }


    @Override
    public PermissionListResponse getPermission(long id) {
        final PermissionListResponse response = new PermissionListResponse();
        return permissionRepository.findById(id)
                .map(entity -> PermissionListResponse.builder().permission(Collections.singletonList(permissionConverter.toDto(entity))).build())
                .orElse(response);
    }

    @Override
    public PermissionListResponse getAllPermissions() {
        final List<PermissionEntity> entities = permissionRepository.findAll();

        final List<PermissionDto> converted = entities
                .stream()
                .map(permissionConverter::toDto)
                .collect(Collectors.toList());

        return PermissionListResponse.builder().permission(converted).build();

    }

    @Override
    public PermissionDto createPermission(PermissionRequest request) {
        UserListResponse userListResponse = userService.getUser(request.getUserId());
        if (userListResponse.getUsers() != null && userListResponse.getUsers().size() > 0) {
            final PermissionEntity saved = permissionRepository.save(permissionConverter.toEntity(request));
            return permissionConverter.toDto(saved);
        }
        return null;
    }

    @Override
    public PermissionDto updatePermission(long id, PermissionRequest request) {
        final Optional<PermissionEntity> optionalPermissionEntity = permissionRepository.findById(id);
        if (!optionalPermissionEntity.isPresent()) {
            return null;
        } else {
            final PermissionEntity toBeUpdated = permissionConverter.toEntity(request);
            toBeUpdated.setId(optionalPermissionEntity.get().getId());
            final PermissionEntity saved = permissionRepository.save(toBeUpdated);
            return permissionConverter.toDto(saved);
        }

    }

    @Override
    public PermissionDeleteResponse deletePermission(long id) {
        if (!permissionRepository.existsById(id)) {
            return PermissionDeleteResponse.builder().deletedPermissionCount(0L).build();
        } else {
            permissionRepository.deleteById(id);
            return PermissionDeleteResponse.builder().deletedPermissionCount(1L).build();
        }
    }


    @Override
    public PermissionListResponse findPermissionByUser(UUID userId) {
        final List<PermissionEntity> entities = permissionRepository.findPermissionByUserId(userId);

        final List<PermissionDto> converted = entities
                .stream()
                .map(permissionConverter::toDto)
                .collect(Collectors.toList());

        return PermissionListResponse.builder().permission(converted).build();
    }

}

