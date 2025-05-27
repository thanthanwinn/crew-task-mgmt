package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReportRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @ManyToOne
    private Crew crew;
    private String content;
    @OneToOne
    private TaskSchedule taskSchedule;
    private LocalDate requestDate;
    private LocalDate approvedDate;
    private String approvedBy;
    @OneToOne
    private ApprovalLog approvalLogs;
}
