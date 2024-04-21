package com.example.taskmanagementsystem.controllers;

import com.example.taskmanagementsystem.dto.auth.JwtRequestDTO;
import com.example.taskmanagementsystem.dto.auth.JwtResponseDTO;
import com.example.taskmanagementsystem.dto.entity.PersonDTO;
import com.example.taskmanagementsystem.mappers.PersonMapper;
import com.example.taskmanagementsystem.models.Person;
import com.example.taskmanagementsystem.service.AuthService;
import com.example.taskmanagementsystem.service.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller")
public class AuthController {
    private final PersonMapper personMapper;
    private final PersonService personService;
    private final AuthService authService;

    @PostMapping("/register")
    public PersonDTO register(@RequestBody @Validated final  PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        Person createdPerson = personService.create(person);
        return personMapper.toDto(createdPerson);
    }
    @PostMapping("/login")
    public JwtResponseDTO login(@RequestBody @Validated JwtRequestDTO requestDTO){
        return authService.login(requestDTO);
    }
}
