package org.landscape.api.model.dto;

import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class 
UserDto implements Serializable{
        private UUID id;
        private String fullName;
        private String email;
        private String password;

}