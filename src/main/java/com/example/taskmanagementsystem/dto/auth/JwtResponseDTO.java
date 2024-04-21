package com.example.taskmanagementsystem.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Request after login")
public class JwtResponseDTO {

    private Long id;
    private String email;
    private String accessToken;
    private String refreshToken;

}
