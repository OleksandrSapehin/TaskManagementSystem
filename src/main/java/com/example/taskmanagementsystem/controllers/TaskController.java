package com.example.taskmanagementsystem.controllers;
import com.example.taskmanagementsystem.dto.entity.TaskDTO;
import com.example.taskmanagementsystem.mappers.TaskMapper;
import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.security.PersonDetailService;
import com.example.taskmanagementsystem.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
@Tag(name = "Task Controller")
public class TaskController {
    private final TaskMapper taskMapper;
    private final TaskService taskService;
    private final PersonDetailService personDetailService;

    @GetMapping("/all")
    public List<TaskDTO> getAllTask(){
        List<Task> tasks = taskService.getAll();
        return taskMapper.toDto(tasks);
    }

    @GetMapping("/{id}/byAuthor")
    public List<TaskDTO> getTaskByAuthor(@PathVariable Long id){
        List<Task> tasks = taskService.getByTaskAuthorId(id);
        return taskMapper.toDto(tasks);
    }

    @GetMapping("/{id}/byAssignee")
    public List<TaskDTO> getTaskByAssignee(@PathVariable Long id){
        List<Task> tasks = taskService.getByTaskAssigneeId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/create")
    public TaskDTO createTask(@RequestBody @Validated final TaskDTO dto) {
        Long personId = personDetailService.getAuthPersonId();
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, personId);
        return taskMapper.toDto(createdTask);
    }

    @PutMapping("/update")
    public TaskDTO updateTask(@RequestBody @Validated TaskDTO taskDTO){
        Task task = taskMapper.toEntity(taskDTO);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }

    @PutMapping("/updateStatus")
    public TaskDTO updateStatus(@RequestBody @Validated TaskDTO taskDTO){
        Task task = taskMapper.toEntity(taskDTO);
        Task updatedTask = taskService.changeStatus(task);
        return taskMapper.toDto(updatedTask);
    }

    @PutMapping("/{taskId}/setAssignee")
    public ResponseEntity<?> setAssignees(@PathVariable Long taskId, @RequestBody List<Long> personId){
        taskService.setAssignee(taskId,personId);
        return ResponseEntity.ok("Task assigned");
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }


}
