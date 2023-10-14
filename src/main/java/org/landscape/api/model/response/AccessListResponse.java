package org.landscape.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import org.landscape.api.model.dto.AccessDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessListResponse implements Serializable {
    private List<AccessDto> permission;
}
