package com.example.taskmanagementsystem.dto.entity;

import com.example.taskmanagementsystem.enums.TaskPriority;
import com.example.taskmanagementsystem.enums.TaskStatus;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Schema(description = "Task DTO")
public class TaskDTO {

    @Hidden
    private Long id;

    @NotNull(message = "Title must be not null.")
    private String title;

    @NotNull(message = "Description must be not null.")
    private String description;

    private TaskPriority taskPriority;

    private TaskStatus taskStatus;

}
