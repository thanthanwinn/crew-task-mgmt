package org.mdt.crewtaskmanagement.dto.task;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {
    private long id;
    private String title;
    private String description;
    private String category;
}
