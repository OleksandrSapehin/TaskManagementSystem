package com.example.taskmanagementsystem.service.Impl;

import com.example.taskmanagementsystem.dto.auth.JwtRequestDTO;
import com.example.taskmanagementsystem.dto.auth.JwtResponseDTO;
import com.example.taskmanagementsystem.models.Person;
import com.example.taskmanagementsystem.security.JwtTokenProvider;
import com.example.taskmanagementsystem.service.AuthService;
import com.example.taskmanagementsystem.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PersonService personService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponseDTO login(JwtRequestDTO loginRequest) {
        JwtResponseDTO jwtResponse = new JwtResponseDTO();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(), loginRequest.getPassword())
        );
        Person person = personService.getByEmail(loginRequest.getEmail());
        jwtResponse.setId(person.getId());
        jwtResponse.setEmail(person.getEmail());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(
                person.getId(), person.getEmail())
        );
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(
                person.getId(), person.getEmail())
        );
        return jwtResponse;
    }

}
