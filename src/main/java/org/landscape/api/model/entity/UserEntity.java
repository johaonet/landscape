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
@Table(name = "USER",uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column
    private String password;


}
