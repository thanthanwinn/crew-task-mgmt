package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ShipRepository extends JpaRepository<Ship, Long> {
}
