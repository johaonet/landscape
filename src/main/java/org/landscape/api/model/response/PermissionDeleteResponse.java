package org.landscape.api.model.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PermissionDeleteResponse implements Serializable {
    private Long deletedPermissionCount;
}
