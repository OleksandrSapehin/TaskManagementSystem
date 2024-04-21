package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.models.Person;

public interface PersonService {

     Person getByEmail(String email);

     Person getById(Long id);

     Person create(Person person);

}
