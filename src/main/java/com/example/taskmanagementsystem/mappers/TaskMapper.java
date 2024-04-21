package com.example.taskmanagementsystem.mappers;

import com.example.taskmanagementsystem.dto.entity.TaskDTO;
import com.example.taskmanagementsystem.models.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDTO>{
}
