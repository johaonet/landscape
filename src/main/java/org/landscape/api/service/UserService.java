package org.landscape.api.service;

import java.util.UUID;

import org.landscape.api.model.dto.UserDto;
import org.landscape.api.model.dto.UserPermissionDto;
import org.landscape.api.model.request.UserLoginRequest;
import org.landscape.api.model.request.UserRequest;
import org.landscape.api.model.response.UserDeleteResponse;
import org.landscape.api.model.response.UserListResponse;

public interface UserService {
    UserPermissionDto findByEmail(UserLoginRequest request);
    
    UserListResponse getUser(UUID id);

    UserListResponse getAllUsers();

    UserDto createUser(UserRequest request);

    UserDto updateUser(UUID id, UserRequest request);

    UserDeleteResponse deleteUser(UUID id);

    UserDeleteResponse deleteAllUsers();

}
