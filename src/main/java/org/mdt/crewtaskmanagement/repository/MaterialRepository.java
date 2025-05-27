package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
