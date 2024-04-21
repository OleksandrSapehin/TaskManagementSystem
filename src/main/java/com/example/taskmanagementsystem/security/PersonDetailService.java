package com.example.taskmanagementsystem.security;

import com.example.taskmanagementsystem.models.Person;
import com.example.taskmanagementsystem.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonDetailService implements UserDetailsService {
    private final PersonService personService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Person person = personService.getByEmail(username);
        return PersonDetailsFactory.create(person);
    }

    public Long getAuthPersonId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetailsImpl personDetails = (PersonDetailsImpl) authentication.getPrincipal();
        return personDetails.getId();
    }

}
