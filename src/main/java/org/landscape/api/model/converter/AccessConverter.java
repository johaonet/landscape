package org.landscape.api.model.converter;

import org.landscape.api.model.dto.AccessDto;
import org.landscape.api.model.entity.AccessEntity;
import org.landscape.api.model.request.AccessRequest;
import org.springframework.stereotype.Component;

@Component
public class AccessConverter {
    public AccessDto toDto(AccessEntity entity) {
        if (entity == null) {
            return null;
        } else {
            return AccessDto.builder()
                    .id(entity.getId())
                    .userId(entity.getUserId())
                    .timestamp(entity.getTimestamp())
                    .build();
        }
    }

    public AccessRequest toRequest(AccessDto dto) {
        if (dto == null) {
            return null;
        } else {
            return AccessRequest.builder()
                    .id(dto.getId())
                    .userId(dto.getUserId())
                    .timestamp(dto.getTimestamp())
                    .build();
        }
    }

    public AccessEntity toEntity(AccessRequest dto) {
        if (dto == null) {
            return null;
        } else {
            return AccessEntity.builder()
                    .id(dto.getId())
                    .userId(dto.getUserId())
                    .timestamp(dto.getTimestamp())
                    .build();
        }
    }

}
