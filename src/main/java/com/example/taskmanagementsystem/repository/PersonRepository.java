package com.example.taskmanagementsystem.repository;

import com.example.taskmanagementsystem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
   Optional<Person> findPersonByEmail(String email);
   Boolean existsPersonByEmail(String email);
}
