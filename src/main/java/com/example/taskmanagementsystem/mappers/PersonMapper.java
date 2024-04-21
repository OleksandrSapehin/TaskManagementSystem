package com.example.taskmanagementsystem.mappers;

import com.example.taskmanagementsystem.dto.entity.PersonDTO;
import com.example.taskmanagementsystem.models.Person;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PersonMapper extends Mappable<Person, PersonDTO> {
}
