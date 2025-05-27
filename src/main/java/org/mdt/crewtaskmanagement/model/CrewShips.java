package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "crew_ships")
@Getter
@Setter
@NoArgsConstructor
public class CrewShips{
    @EmbeddedId
    private CrewShipsId id;

    @Column(name = "assigned_date")
    private LocalDate assignedDate;

    @Column(name = "created_at", columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne
    @MapsId("crewId")
    @JoinColumn(name = "crew_id", insertable = false, updatable = false)
    private Crew crew;

    @ManyToOne
    @MapsId("shipId")
    @JoinColumn(name = "ship_id", insertable = false, updatable = false)
    private Ship ship;

    // You can add a convenience constructor
    public CrewShips(Long crewId, Long shipId, LocalDate assignedDate, String createdBy) {
        this.id = new CrewShipsId(crewId, shipId);
        this.assignedDate = assignedDate;
        this.createdBy = createdBy;
    }
}
