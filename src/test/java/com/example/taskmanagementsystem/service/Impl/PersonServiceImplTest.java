package com.example.taskmanagementsystem.service.Impl;

import com.example.taskmanagementsystem.enums.PersonRoles;
import com.example.taskmanagementsystem.models.Person;
import com.example.taskmanagementsystem.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    PersonServiceImpl personService;

    @Test
    void getByEmail() {

        String email = "test@example.com";
        Person person = new Person();
        person.setEmail(email);

        when(personRepository.findPersonByEmail(email)).thenReturn(Optional.of(person));

        Person result = personService.getByEmail(email);

        assertNotNull(result);
        assertEquals(email, result.getEmail());

    }

    @Test
    void getById() {

        Long id = 1L;
        Person person = new Person();
        person.setId(id);

        when(personRepository.findById(id)).thenReturn(Optional.of(person));

        Person result = personService.getById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());

    }

    @Test
    void create() {

        Person person = new Person();
        person.setEmail("test@example.com");
        person.setPassword("password");

        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        personService.create(person);

        verify(passwordEncoder).encode("password");
        verify(personRepository).save(person);

        assertEquals("encodedPassword", person.getPassword());
        assertEquals(PersonRoles.ROLE_USER, person.getRole());

    }
}