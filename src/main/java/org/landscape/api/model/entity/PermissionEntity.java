package org.landscape.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERMISSION")
public class PermissionEntity {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private UUID userId;

    @Column
    private String permission;
}
