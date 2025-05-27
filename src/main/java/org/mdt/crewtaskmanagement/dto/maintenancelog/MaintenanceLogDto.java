package org.mdt.crewtaskmanagement.dto.maintenancelog;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaintenanceLogDto {
    private long id;
    private String title;
    private String remark;
    private String maintainedBy;
}
