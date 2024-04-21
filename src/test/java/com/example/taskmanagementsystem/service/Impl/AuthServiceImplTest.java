package com.example.taskmanagementsystem.service.Impl;

import com.example.taskmanagementsystem.dto.auth.JwtRequestDTO;
import com.example.taskmanagementsystem.dto.auth.JwtResponseDTO;
import com.example.taskmanagementsystem.models.Person;
import com.example.taskmanagementsystem.security.JwtTokenProvider;
import com.example.taskmanagementsystem.service.PersonService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

     @Mock
     PersonService personService;
     @Mock
     AuthenticationManager authenticationManager;
     @Mock
     JwtTokenProvider tokenProvider;

     @InjectMocks
     AuthServiceImpl authService;

    @Test
    void login() {

        Long userId = 1L;
        String email = "email@gmail.com";
        String password = "password";
        String accessToken = "accessToken";
        String refreshToken = "refreshToken";
        JwtRequestDTO request = new JwtRequestDTO();
        request.setEmail(email);
        request.setPassword(password);
        Person person = new Person();
        person .setId(userId);
        person .setEmail(email);
        Mockito.when(personService.getByEmail(email))
                .thenReturn(person);
        Mockito.when(tokenProvider.createAccessToken(userId, email))
                .thenReturn(accessToken);
        Mockito.when(tokenProvider.createRefreshToken(userId, email))
                .thenReturn(refreshToken);
        JwtResponseDTO response = authService.login(request);
        Mockito.verify(authenticationManager)
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword())
                );
        Assertions.assertEquals(response.getEmail(), email);
        Assertions.assertEquals(response.getId(), userId);
        Assertions.assertNotNull(response.getAccessToken());
        Assertions.assertNotNull(response.getRefreshToken());

    }
}