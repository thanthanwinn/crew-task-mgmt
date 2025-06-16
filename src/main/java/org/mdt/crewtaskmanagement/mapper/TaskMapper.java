package org.mdt.crewtaskmanagement.mapper;

import org.mdt.crewtaskmanagement.dto.task.TaskDto;
import org.mdt.crewtaskmanagement.model.Task;
import org.mdt.crewtaskmanagement.model.type.Category;
import org.mdt.crewtaskmanagement.model.type.Maintenance;

public class TaskMapper {

    public static Task fromDto(TaskDto dto) {
        if (dto == null) {
            return null;
        }

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setPosition(dto.getPosition());
        task.setDescription(dto.getDescription());
        task.setTaskType(Enum.valueOf(Maintenance.class, dto.getTaskType()));

        if (dto.getCategory() != null) {
            task.setCategory(Enum.valueOf(Category.class, dto.getCategory()));
        }

        // Only set ID if present in DTO (not 0)
        if (dto.getId() != 0L) {
            task.setId(dto.getId());
        }

        return task;
    }

    public static TaskDto toDto(Task entity) {
        if (entity == null) {
            return null;
        }

        return TaskDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .taskType(entity.getTaskType().name())
                .position(entity.getPosition())
                .description(entity.getDescription())
                .category(String.valueOf(entity.getCategory().toString()))
                .build();
    }

    public static TaskDto toDtoWithScheduleCount(Task entity) {
        if (entity == null) {
            return null;
        }
        TaskDto dto = toDto(entity);
        return dto;
    }
}
