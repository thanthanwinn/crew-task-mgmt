package org.mdt.crewtaskmanagement.service;

import org.mdt.crewtaskmanagement.dto.task.CrewTaskDto;
import org.mdt.crewtaskmanagement.dto.task.TaskDto;
import org.mdt.crewtaskmanagement.model.Task;

import java.util.List;

public interface TaskService {
    public TaskDto registerTask(TaskDto dto);
    public TaskDto updateTask(TaskDto dto);
    public TaskDto getTaskById(long id);
    public List<TaskDto> getAllTasks();
    public void deleteTask(long id);
    public void assignTaskToCrew(long taskId, long crewId);
    public List<CrewTaskDto> getTasksByCrewId(long crewId);

}
