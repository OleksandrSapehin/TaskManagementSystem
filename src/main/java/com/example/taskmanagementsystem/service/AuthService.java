package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.dto.auth.JwtRequestDTO;
import com.example.taskmanagementsystem.dto.auth.JwtResponseDTO;

public interface AuthService {

    JwtResponseDTO login(JwtRequestDTO loginRequest);

}
