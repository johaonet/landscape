package org.landscape.api.repository;

import java.util.List;
import java.util.UUID;

import org.landscape.api.model.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    List<PermissionEntity> findPermissionByUserId(UUID userId);

}
