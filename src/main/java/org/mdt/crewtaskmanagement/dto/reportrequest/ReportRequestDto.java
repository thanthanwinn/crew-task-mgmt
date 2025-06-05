package org.mdt.crewtaskmanagement.dto.reportrequest;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReportRequestDto {
    private long id;
    private String title;
    private long crewId;
    private long t_a_id;
    private String reportType;//user enter
    private String content; //user enter
    private String requestDate; //user enter

}
