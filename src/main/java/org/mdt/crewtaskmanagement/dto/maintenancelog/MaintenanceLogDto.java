package org.mdt.crewtaskmanagement.dto.maintenancelog;

import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@Builder
public class MaintenanceLogDto {
    private Long id;
    @NotNull
    private Long materialId;
    @NotNull
    private Long shipId;
    private Long taskAssignmentId;
    @NotNull
    private String title;
    private String remark;
    @NotNull
    private String maintainedBy;
    @NotNull
    private LocalDate maintainedDate;
    private LocalDate nextDueDate;
    private String category;
    private String status;
}
