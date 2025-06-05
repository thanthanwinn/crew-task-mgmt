package org.mdt.crewtaskmanagement.mapper;

import org.mdt.crewtaskmanagement.dto.task.CrewTaskDto;
import org.mdt.crewtaskmanagement.model.TaskAssignment;

public class CrewTaskMapper {

    public static CrewTaskDto toDto(TaskAssignment entity) {
        if (entity == null) return null;

        return CrewTaskDto.builder()
                .id((int) entity.getId())
                .crewId(entity.getCrew().getId())
                .crewName(entity.getCrew().getFirstName() + " " + entity.getCrew().getLastName())
                .shipName(entity.getShip().getName())
                .taskId(entity.getTask().getId())
                .taskTitle(entity.getTask().getTitle())
                .taskDescription(entity.getTask().getDescription())
                .category(entity.getTask().getCategory().toString())
                .assignedDate(entity.getAssignedDate().toString())
                .deadlineDate(entity.getDeadlineDate().toString())
                .completed(entity.isCompleted())
                .build();
    }
}
