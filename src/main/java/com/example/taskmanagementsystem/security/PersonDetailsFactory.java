package com.example.taskmanagementsystem.security;

import com.example.taskmanagementsystem.models.Person;

public final class PersonDetailsFactory {

    public static PersonDetailsImpl create(final Person person) {
        return new PersonDetailsImpl(
                person.getId(),
                person.getEmail(),
                person.getName(),
                person.getPassword()
        );
    }

}
