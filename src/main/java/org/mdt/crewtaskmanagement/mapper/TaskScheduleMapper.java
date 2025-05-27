package org.mdt.crewtaskmanagement.mapper;

import org.mdt.crewtaskmanagement.dto.taskschedule.TaskScheduleDto;
import org.mdt.crewtaskmanagement.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskScheduleMapper {

    public static TaskSchedule fromDto(TaskScheduleDto dto, Task task, Crew crew, Ship ship) {
        if (dto == null) {
            return null;
        }

        TaskSchedule taskSchedule = new TaskSchedule();
        taskSchedule.setTask(task);
        taskSchedule.setCrew(crew);
        taskSchedule.setShip(ship);
        taskSchedule.setAssignedDate(parseDate(dto.getAssignDate()));
        taskSchedule.setDeadlineDate(parseDate(dto.getDeadlineDate()));
        taskSchedule.setCompleted(dto.isCompleted());

        // Only set ID if present in DTO (not 0)
        if (dto.getId() != 0L) {
            taskSchedule.setId(dto.getId());
        }

        return taskSchedule;
    }

    public static TaskScheduleDto toDto(TaskSchedule entity) {
        if (entity == null) {
            return null;
        }

        return TaskScheduleDto.builder()
                .id(entity.getId())
                .taskName(entity.getTask() != null ? entity.getTask().getTitle() : null)
                .crewName(entity.getCrew() != null ?
                        String.format("%s %s", entity.getCrew().getFirstName(), entity.getCrew().getLastName()) : null)
                .shipName(entity.getShip() != null ? entity.getShip().getName() : null)
                .assignDate(formatDate(entity.getAssignedDate()))
                .deadlineDate(formatDate(entity.getDeadlineDate()))
                .completed(entity.isCompleted())
                .build();
    }

    // Optional: Include related entity IDs in the DTO
    public static TaskScheduleDto toDtoWithIds(TaskSchedule entity) {
        if (entity == null) {
            return null;
        }

        TaskScheduleDto dto = toDto(entity);
        // Add related entity IDs if needed
        return dto;
    }

    private static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString, e);
        }
    }

    private static String formatDate(LocalDate date) {
        return date != null ? date.toString() : null;
    }
}
