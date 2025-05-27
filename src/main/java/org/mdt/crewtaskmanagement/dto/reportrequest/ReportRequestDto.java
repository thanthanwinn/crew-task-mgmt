package org.mdt.crewtaskmanagement.dto.reportrequest;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReportRequestDto {
    private long id;
    private String title;
    private String content;
    private String requestDate;
    private String approvedDate;
    private String approvedBy;
}
