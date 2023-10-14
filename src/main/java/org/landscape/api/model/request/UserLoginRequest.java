package org.landscape.api.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserLoginRequest implements Serializable {
    private String email;
    private String password;
}
