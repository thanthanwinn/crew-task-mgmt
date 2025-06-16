package org.mdt.crewtaskmanagement.repository;

import org.mdt.crewtaskmanagement.dto.material.MaterialForRequestDto;
import org.mdt.crewtaskmanagement.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {
//
//    @Query("SELECT m FROM material" +
//            "ORDER BY some_column\n" +
//            "LIMIT 2;\n")
    @Query("select m from Material  m where m.name = :materialName order by m.id limit :quantity")
    Optional<List<Material>> findByMaterialName(@Param("materialName")String materialName, @Param("quantity") int quantity);

    @Query("""
    SELECT new org.mdt.crewtaskmanagement.dto.material.MaterialForRequestDto(
        MIN(m.id),          
        m.name,
        MIN(m.type),
        MIN(m.price),
        MIN(m.condition),
        MIN(m.receivedDate),
        MIN(m.lifeTime),
        COUNT(m)
    )
    FROM Material m
    WHERE m.useStatus = false
    GROUP BY m.name
""")
    List<MaterialForRequestDto> findAllMaterialsForRequest();





}
