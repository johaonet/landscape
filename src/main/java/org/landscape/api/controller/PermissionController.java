package org.landscape.api.controller;
import org.landscape.api.model.dto.PermissionDto;
import org.landscape.api.model.request.PermissionRequest;
import org.landscape.api.model.response.PermissionDeleteResponse;
import org.landscape.api.model.response.PermissionListResponse;
import org.landscape.api.service.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/permission/{id}")
    public ResponseEntity<PermissionListResponse> getPermission(@PathVariable("id") long id) {
        PermissionListResponse response = permissionService.getPermission(id);

        if (CollectionUtils.isEmpty(response.getPermission())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/permissions")
    public ResponseEntity<PermissionListResponse> getAllPermissions() {
        PermissionListResponse response = permissionService.getAllPermissions();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/permission")
    public ResponseEntity<PermissionDto> createPermission(@RequestBody PermissionRequest request) {
        PermissionDto permissionDto = permissionService.createPermission(request);
        if (null != permissionDto) {
            return new ResponseEntity<>(permissionDto, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(permissionDto, HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/permission/{id}")
    public ResponseEntity<PermissionDto> updatePermission(@PathVariable("id") long id, @RequestBody PermissionRequest request) {
        PermissionDto permissionDto = permissionService.updatePermission(id, request);
        if (null == permissionDto) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(permissionDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("/permission/{id}")
    public ResponseEntity<PermissionDeleteResponse> deletePermission(@PathVariable("id") long id) {
        PermissionDeleteResponse response = permissionService.deletePermission(id);
        if (0L == response.getDeletedPermissionCount()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
