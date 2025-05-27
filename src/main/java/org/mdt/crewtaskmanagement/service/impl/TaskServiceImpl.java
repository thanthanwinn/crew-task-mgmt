package org.mdt.crewtaskmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.task.TaskDto;
import org.mdt.crewtaskmanagement.mapper.TaskMapper;
import org.mdt.crewtaskmanagement.model.Task;
import org.mdt.crewtaskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl {
    private final TaskRepository taskRepository;

    public TaskDto registerTask(TaskDto dto){
        Task task = TaskMapper.fromDto(dto);
        taskRepository.save(task);
        return TaskMapper.toDto(task);
    }

    public TaskDto updateTask(TaskDto dto){
        Task task = TaskMapper.fromDto(dto);
        task.setId(dto.getId());
        taskRepository.save(task);
        return TaskMapper.toDto(task);
    }

    public TaskDto getTaskById(long id){
        return TaskMapper.toDto(taskRepository.findById(id).orElseThrow());
    }
    public List<TaskDto> getAllTasks(){
        return taskRepository.findAll().stream().map(TaskMapper::toDto).collect(Collectors.toList());
    }

    public void deleteTaskById(long id){
        taskRepository.deleteById(id);
    }


}
