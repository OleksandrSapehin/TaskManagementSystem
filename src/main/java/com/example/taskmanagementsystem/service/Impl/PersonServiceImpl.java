package com.example.taskmanagementsystem.service.Impl;

import com.example.taskmanagementsystem.enums.PersonRoles;
import com.example.taskmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.taskmanagementsystem.models.Person;
import com.example.taskmanagementsystem.repository.PersonRepository;
import com.example.taskmanagementsystem.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Person getByEmail(String email) {
        return personRepository.findPersonByEmail(email).orElseThrow(()->new ResourceNotFoundException("User not found."));
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found."));
    }

    @Override
    @Transactional
    public Person create(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(PersonRoles.ROLE_USER);
        personRepository.save(person);
        return person;
    }

}
