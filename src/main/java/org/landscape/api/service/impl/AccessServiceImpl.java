package org.landscape.api.service.impl;

import org.landscape.api.model.converter.AccessConverter;
import org.landscape.api.model.dto.AccessDto;
import org.landscape.api.model.entity.AccessEntity;
import org.landscape.api.model.request.AccessRequest;
import org.landscape.api.model.response.AccessListResponse;
import org.landscape.api.repository.AccessRepository;
import org.landscape.api.service.AccessService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessServiceImpl implements AccessService {

    private final AccessRepository repository;
    private final AccessConverter accessConverter;

    public AccessServiceImpl(AccessRepository repository, AccessConverter accessConverter) {
        this.repository = repository;
        this.accessConverter = accessConverter;
    }
    @Override
    public AccessListResponse getAllAccess() {
        final List<AccessEntity> entities = repository.findAll();

        final List<AccessDto> converted = entities
                .stream()
                .map(accessConverter::toDto)
                .collect(Collectors.toList());

        return AccessListResponse.builder().permission(converted).build();

    }

    @Override
    public AccessDto createAccess(AccessRequest request) {
        final AccessEntity saved = repository.save(accessConverter.toEntity(request));
        return accessConverter.toDto(saved);
    }


}

