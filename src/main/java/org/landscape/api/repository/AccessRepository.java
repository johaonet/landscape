package org.landscape.api.repository;

import org.landscape.api.model.entity.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<AccessEntity, Long> {
}
