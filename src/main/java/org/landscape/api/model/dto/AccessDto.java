package org.landscape.api.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessDto implements Serializable {

    private Long id; 
    private UUID userId;
    private LocalDateTime timestamp;
}
