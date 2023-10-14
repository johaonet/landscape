package org.landscape.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import org.landscape.api.model.dto.PermissionDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionListResponse implements Serializable {
    private List<PermissionDto> permission;
}
