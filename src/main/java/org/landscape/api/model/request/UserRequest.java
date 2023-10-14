package org.landscape.api.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class UserRequest implements Serializable {
    private UUID id;
    private String fullName;
    private String email;
    private String password;
}
