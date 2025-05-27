package org.mdt.crewtaskmanagement.dto.taskschedule;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskScheduleDto {
    private long id;
    private String taskName;
    private String crewName;
    private String shipName;
    private String assignDate;
    private String deadlineDate;
    private boolean completed;

}
