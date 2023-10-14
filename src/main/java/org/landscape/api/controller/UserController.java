package org.landscape.api.controller;

import java.util.UUID;

import org.landscape.api.model.dto.UserDto;
import org.landscape.api.model.dto.UserPermissionDto;
import org.landscape.api.model.request.UserLoginRequest;
import org.landscape.api.model.request.UserRequest;
import org.landscape.api.model.response.UserDeleteResponse;
import org.landscape.api.model.response.UserListResponse;
import org.landscape.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserListResponse> getUser(@PathVariable("id") UUID id) {
        UserListResponse response = userService.getUser(id);

        if (CollectionUtils.isEmpty(response.getUsers())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @GetMapping("/users")
    public ResponseEntity<UserListResponse> getAllUsers() {
        UserListResponse response = userService.getAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<UserPermissionDto> login(@RequestBody UserLoginRequest request) {
        UserPermissionDto userPermissionDto = userService.findByEmail(request);
        if (null == userPermissionDto) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(userPermissionDto, HttpStatus.OK);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDto> updateCustomer(@PathVariable("id") UUID id, @RequestBody UserRequest request) {
        UserDto userDto = userService.updateUser(id, request);
        if (null == userDto) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserDeleteResponse> deleteUser(@PathVariable("id") UUID id) {
        UserDeleteResponse response = userService.deleteUser(id);
        if (0L == response.getDeletedUserCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/user")
    public ResponseEntity<UserDeleteResponse> deleteAllUsers() {
        UserDeleteResponse response = userService.deleteAllUsers();
        if (0L == response.getDeletedUserCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
