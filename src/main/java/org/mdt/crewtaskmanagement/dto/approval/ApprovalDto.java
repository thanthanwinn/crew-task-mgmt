package org.mdt.crewtaskmanagement.dto.approval;

import lombok.Data;

@Data
public class ApprovalDto {
    private long id;
    private long crewId;
    private long reportRequestId;
}
