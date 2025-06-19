package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
@Entity
@Table(name = "maintenance_log")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class MaintenanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maintenance_id", nullable = false)
    private Maintenance maintenance;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crew_id", nullable = false)
    private Crew maintainedBy;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_responsible_crew_id")
    private Crew nextResponsiblePerson;

    @Column(nullable = false)
    private String remark;

    @NotNull
    private LocalDate maintainedDate;

    @NonNull
    private LocalDate nextDueDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status;

    public enum MaintenanceStatus {
        COMPLETED, PENDING, FAILED
    }


}
