package org.landscape.api.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class AccessRequest implements Serializable {
    private Long id; 
    private UUID userId;
    private LocalDateTime timestamp;

}