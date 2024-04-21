package com.example.taskmanagementsystem.service.Impl;

import com.example.taskmanagementsystem.enums.TaskStatus;
import com.example.taskmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.taskmanagementsystem.models.Person;
import com.example.taskmanagementsystem.models.Task;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.service.PersonService;
import com.example.taskmanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PersonService personService;

    @Transactional
    @Override
    public Task create(Task task, Long id) {
        task.setTaskStatus(TaskStatus.TO_DO);
        Person person = personService.getById(id);
        task.setTaskAuthor(person);
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id is null"));
    }

    @Transactional
    @Override
    public Task update(Task task) {
        Task newTask = getById(task.getId());
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setTaskPriority(task.getTaskPriority());
        taskRepository.save(newTask);
        return newTask;
    }

    @Transactional
    @Override
    public void deleteById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<Task> getAll() {
      return taskRepository.findAll();
    }

    @Override
    public List<Task> getByTaskAuthorId(Long authorId) {
        Optional.ofNullable(authorId)
                .orElseThrow(()-> new ResourceNotFoundException("Id cannot be null"));

        List<Task> tasks = taskRepository.getTaskByTaskAuthorId(authorId);

        Optional.of(tasks)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("author dont have tasks"));

        return tasks;
    }

    @Override
    public List<Task> getByTaskAssigneeId(Long assigneeId) {
        Optional.ofNullable(assigneeId)
                .orElseThrow(()-> new ResourceNotFoundException("Id cannot be null"));

        List<Task> tasks = taskRepository.getTaskByAssigneesId(assigneeId);

        Optional.of(tasks)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("Assignee dont have tasks"));

        return tasks;
    }

    @Transactional
    @Override
    public Task changeStatus(Task task) {
        Task newTask = getById(task.getId());
        newTask.setTaskStatus(task.getTaskStatus());
        taskRepository.save(newTask);
        return newTask;
    }

    @Transactional
    @Override
    public void setAssignee(Long taskId, List<Long> personId) {
        Task taskById = getById(taskId);
        personId.forEach(Id -> {
            Person personById = personService.getById(Id);
            taskById.getAssignees().add(personById);
        });

        taskRepository.save(taskById);
    }
}
