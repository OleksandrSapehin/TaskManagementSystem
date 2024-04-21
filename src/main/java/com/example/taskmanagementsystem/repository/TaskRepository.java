package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> getTaskByTaskAuthorId(Long authorId);

    List<Task> getTaskByAssigneesId(Long assigneesId);

}
