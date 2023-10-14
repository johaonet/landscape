package org.landscape.api.service.impl;

import org.landscape.api.model.converter.AccessConverter;
import org.landscape.api.model.converter.UserConverter;
import org.landscape.api.model.converter.UserPermissionConverter;
import org.landscape.api.model.dto.AccessDto;
import org.landscape.api.model.dto.UserDto;
import org.landscape.api.model.dto.UserPermissionDto;
import org.landscape.api.model.entity.PermissionEntity;
import org.landscape.api.model.entity.UserEntity;
import org.landscape.api.model.request.UserLoginRequest;
import org.landscape.api.model.request.UserRequest;
import org.landscape.api.model.response.UserDeleteResponse;
import org.landscape.api.model.response.UserListResponse;
import org.landscape.api.repository.PermissionRepository;
import org.landscape.api.repository.UserRepository;
import org.landscape.api.service.AccessService;
import org.landscape.api.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final UserConverter userConverter;
    private final AccessService accessService;
    private final AccessConverter accessConverter;
    private final UserPermissionConverter userPermissionConverter;


    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter, AccessService accessService, AccessConverter accessConverter, PermissionRepository permissionRepository, UserPermissionConverter userPermissionConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.accessService = accessService;
        this.accessConverter = accessConverter;
        this.permissionRepository = permissionRepository;
        this.userPermissionConverter = userPermissionConverter;
    }


    @Override
    public UserListResponse getUser(UUID id) {
        final UserListResponse response = new UserListResponse();
        return userRepository.findById(id)
                .map(entity -> UserListResponse.builder().users(Collections.singletonList(userConverter.toDto(entity))).build())
                .orElse(response);
    }

    @Override
    public UserListResponse getAllUsers() {
        final List<UserEntity> entities = userRepository.findAll();

        final List<UserDto> converted = entities
                .stream()
                .map(userConverter::toDto)
                .collect(Collectors.toList());

        return UserListResponse.builder().users(converted).build();

    }

    @Override
    public UserDto createUser(UserRequest request) {
        final UserEntity userEntity = userRepository.findByEmail(request.getEmail());
        if (userEntity ==null) {
            final UserEntity saved = userRepository.save(userConverter.toEntity(request));
            return userConverter.toDto(saved);
        }
        else{
            return userConverter.toDto(userEntity);
        }
    }

    @Override
    public UserDto updateUser(UUID id, UserRequest request) {
        final Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            return null;
        } else {
            final UserEntity toBeUpdated = userConverter.toEntity(request);
            toBeUpdated.setId(optionalUserEntity.get().getId());
            final UserEntity saved = userRepository.save(toBeUpdated);
            return userConverter.toDto(saved);
        }

    }

    @Override
    public UserDeleteResponse deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            return UserDeleteResponse.builder().deletedUserCount(0L).build();
        } else {
            userRepository.deleteById(id);
            return UserDeleteResponse.builder().deletedUserCount(1L).build();
        }
    }

    @Override
    public UserDeleteResponse deleteAllUsers() {
        final long count = userRepository.count();
        if (count == 0) {
            return UserDeleteResponse.builder().deletedUserCount(0L).build();
        } else {
            userRepository.deleteAll();
            return UserDeleteResponse.builder().deletedUserCount(count).build();
        }
    }


    @Override
    public UserPermissionDto findByEmail(UserLoginRequest request) {
        final UserEntity userEntity = userRepository.findByEmail(request.getEmail());
        if (userEntity != null){
            if (userEntity.getPassword().equals(request.getPassword())) {
                AccessDto accessdDto = new AccessDto();
                accessdDto.setUserId(userEntity.getId());
                accessdDto.setTimestamp(LocalDateTime.now());

                List<PermissionEntity> permissions = permissionRepository.findPermissionByUserId(userEntity.getId());
                accessService.createAccess(accessConverter.toRequest(accessdDto));  
                return userPermissionConverter.toDto(userEntity, permissions);
            }
        }
        return null;
    }

}

