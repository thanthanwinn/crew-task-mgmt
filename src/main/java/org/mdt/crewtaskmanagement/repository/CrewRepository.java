package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CrewRepository extends JpaRepository<Crew, Long> {
    Optional<Crew> findByEmail(String email);
    @Query("SELECT c.id FROM Crew c WHERE c.email = :email")
    Optional<Long> getIdByEmail(@Param("email") String email);

@Query("SELECT c FROM Crew c " +
        "WHERE c.id NOT IN (SELECT ca.crew.id FROM CrewAssignment ca WHERE ca.endDate > CURRENT_DATE) " +
        "OR NOT EXISTS (SELECT 1 FROM CrewAssignment ca2 WHERE ca2.crew = c)")
List<Crew> findAvailableCrewsForAssignment();
@Query(" select ca.crew from CrewAssignment ca where  ca.ship.id = ?1")
List<Crew> findCrewsByShipId(Long shipId);



}
