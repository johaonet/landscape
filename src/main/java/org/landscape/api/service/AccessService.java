package org.landscape.api.service;


import org.landscape.api.model.dto.AccessDto;
import org.landscape.api.model.request.AccessRequest;
import org.landscape.api.model.response.AccessListResponse;

public interface AccessService {

    AccessListResponse getAllAccess();
    AccessDto createAccess(AccessRequest request);


}
