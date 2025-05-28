package org.mdt.crewtaskmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mdt.crewtaskmanagement.model.type.CrewRank;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String approverName;
    private CrewRank position;
    private LocalDateTime approvalTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_log_id")
    private ApprovalLog approvalLog;
}
