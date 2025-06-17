package org.mdt.crewtaskmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.task.CrewTaskDto;
import org.mdt.crewtaskmanagement.dto.task.TaskDto;
import org.mdt.crewtaskmanagement.mapper.CrewTaskMapper;
import org.mdt.crewtaskmanagement.mapper.TaskMapper;
import org.mdt.crewtaskmanagement.model.Crew;
import org.mdt.crewtaskmanagement.model.Ship;
import org.mdt.crewtaskmanagement.model.Task;
import org.mdt.crewtaskmanagement.model.TaskAssignment;
import org.mdt.crewtaskmanagement.repository.CrewRepository;
import org.mdt.crewtaskmanagement.repository.ShipRepository;
import org.mdt.crewtaskmanagement.repository.TaskRepository;
import org.mdt.crewtaskmanagement.repository.TaskScheduleRepository;
import org.mdt.crewtaskmanagement.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final CrewRepository crewRepository;
    private final ShipRepository shipRepository;
    private final TaskScheduleRepository tsrepo;

    @Override
    public List<CrewTaskDto> getTasksByCrewId(long crewId) {
        List<TaskAssignment> assignments = tsrepo.findByCrewIdWithDetails(crewId);
        return assignments.stream()
                .sorted(Comparator.comparing(TaskAssignment::getDeadlineDate))
                .map(CrewTaskMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);

    }

    @Override
    public void assignTaskToCrew(long taskId, long crewId) {
        Task task = taskRepository.findById(taskId).get();
        Crew crew = crewRepository.findById(crewId).get();
        Ship ship = shipRepository.findById(1L).get();
        TaskAssignment ta = new TaskAssignment();
        ta.setTask(task);
        ta.setCrew(crew);
        ta.setShip(ship);
        ta.setAssignedDate(LocalDate.now());
        ta.setDeadlineDate(LocalDate.now());
        tsrepo.save(ta);


    }



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



}
