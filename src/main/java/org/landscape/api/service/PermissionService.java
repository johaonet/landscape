package org.landscape.api.service;


import java.util.UUID;

import org.landscape.api.model.dto.PermissionDto;
import org.landscape.api.model.request.PermissionRequest;
import org.landscape.api.model.response.PermissionDeleteResponse;
import org.landscape.api.model.response.PermissionListResponse;

public interface PermissionService {

    PermissionListResponse findPermissionByUser(UUID userId);

    PermissionListResponse getPermission(long id);

    PermissionListResponse getAllPermissions();

    PermissionDto createPermission(PermissionRequest request);

    PermissionDto updatePermission(long id, PermissionRequest request);

    PermissionDeleteResponse deletePermission(long id);

}
