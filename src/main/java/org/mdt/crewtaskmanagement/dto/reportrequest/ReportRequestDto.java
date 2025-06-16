package org.mdt.crewtaskmanagement.dto.reportrequest;

import lombok.Builder;
import lombok.Data;
import org.mdt.crewtaskmanagement.dto.approval.ApprovalDto;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ReportRequestDto {
    private long id;
    private String title;
    private long crewId;
    private long t_a_id;
    private String reportType;//user enter
    private String content; //user enter
    private String requestDate;
    private List<MaterialRequestDto> requestedMaterials;
    //user enter

}
