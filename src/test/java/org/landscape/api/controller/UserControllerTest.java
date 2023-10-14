package org.landscape.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.landscape.api.base.BaseControllerTest;
import org.landscape.api.model.dto.UserDto;
import org.landscape.api.model.response.UserListResponse;
import org.landscape.api.service.UserService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;
import java.util.Collections;

@WebMvcTest(value = UserController.class)
class UserControllerTest extends BaseControllerTest {

    @Autowired
    private UserController controller;

    @MockBean
    private UserService userService;

    @Test
    void testValidStatuCode() {
        // Arrange
        UUID validUUID = UUID.randomUUID();
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setUsers(Collections.singletonList(new UserDto()));
        Mockito.when(userService.getUser(validUUID)).thenReturn(userListResponse);

        // Act
        ResponseEntity<UserListResponse> response = controller.getUser(validUUID);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testInvalidStatusCode() {
        // Arrange
        UUID invalidUUID = UUID.randomUUID();
        UserListResponse userListResponse = new UserListResponse();
        Mockito.when(userService.getUser(invalidUUID)).thenReturn(userListResponse);

        // Act
        ResponseEntity<UserListResponse> response = controller.getUser(invalidUUID);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    /*@Test
    public void testHandleExceptions() {
        // Arrange
        UUID validUUID = UUID.randomUUID();
        Mockito.when(userService.getUser(validUUID)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<UserListResponse> response = controller.getUser(validUUID);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }*/
}




