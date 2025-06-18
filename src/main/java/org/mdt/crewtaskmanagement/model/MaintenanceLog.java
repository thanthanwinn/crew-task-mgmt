package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MaintenanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //composite primary key
    @OneToOne
    private Material material;
    private String title;
    private String remark;
    private String maintainedBy;
    private LocalDate maintainedDate;
    private LocalDate nextDueDate;

    @PrePersist
    @PreUpdate
    public void calculateNextDueDate() {
        if (maintainedDate != null) {
            nextDueDate = switch (material.getLifeTime().toLowerCase()) {
                case "3 months" -> maintainedDate.plusMonths(3);
                case "6 months" -> maintainedDate.plusMonths(6);
                case "1 year" -> maintainedDate.plusYears(1);
                case "1 month" -> maintainedDate.plusMonths(1);
                default -> null; // or throw exception/log
            };
        }
    }
}
