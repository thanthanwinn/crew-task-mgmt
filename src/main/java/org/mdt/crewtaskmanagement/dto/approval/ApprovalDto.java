package org.mdt.crewtaskmanagement.dto.approval;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ApprovalDto {
    private long id;
    private long crewId;
    private String approvedDate;
    private long reportRequestId;

    public ApprovalDto(long id, long crewId, LocalDateTime approvedDate, long reportRequestId) {
        this.id = id;
        this.crewId = crewId;
        this.approvedDate= approvedDate.toString();
        this.reportRequestId = reportRequestId;
    }
}
