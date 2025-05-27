package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository extends JpaRepository<Crew, Long> {
}
