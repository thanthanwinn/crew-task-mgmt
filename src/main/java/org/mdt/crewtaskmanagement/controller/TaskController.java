package org.mdt.crewtaskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.task.TaskDto;
import org.mdt.crewtaskmanagement.service.TaskService;
import org.mdt.crewtaskmanagement.service.impl.TaskServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mdt/task")
public class TaskController {
    private final TaskServiceImpl taskService;

    @PostMapping("/register")
    public ResponseEntity<TaskDto> registerTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.registerTask(taskDto));
    }

    @PostMapping("/update")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTask(taskDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Deleted task with id " + id);
    }
}
