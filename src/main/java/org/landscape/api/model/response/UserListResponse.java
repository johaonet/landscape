package org.landscape.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import org.landscape.api.model.dto.UserDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListResponse implements Serializable {
    private List<UserDto> users;
}
