package org.landscape.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.landscape.api.base.BaseControllerTest;
import org.landscape.api.model.dto.UserDto;
import org.landscape.api.model.response.PermissionListResponse;
import org.landscape.api.model.response.UserListResponse;
import org.landscape.api.service.PermissionService;
import org.landscape.api.service.UserService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;
import java.util.Collections;

@WebMvcTest(value = UserController.class)
class PermissionControllerTest extends BaseControllerTest {

    @Autowired
    private PermissionController controller;

    @MockBean
    private PermissionService permissionService;
   /* @Test
    public void testValidIdPermissionFound() {
        // Arrange
        long id = 1;
        PermissionController permissionController = new PermissionController(permissionService);
    
        // Act
        ResponseEntity<PermissionListResponse> responseEntity = permissionController.getPermission(id);
    
        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void testValidIdPermissionFoundNonEmptyResponse() {
        // Arrange
        long id = 1;
        PermissionController permissionController = new PermissionController(permissionService);
    
        // Act
        ResponseEntity<PermissionListResponse> responseEntity = permissionController.getPermission(id);
    
        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertFalse(CollectionUtils.isEmpty(responseEntity.getBody().getPermission()));
    }*/

}




