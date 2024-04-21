package com.example.taskmanagementsystem.dto.entity;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;

@Data
@Schema(description = "Person DTO")
public class PersonDTO {

    @Hidden
    private Long id;

    @Schema(description = "User name", example = "John Doe")
    @NotNull(message = "Name must be not null.")
    private String name;

    @Schema(description = "User email", example = "aleks123@gmail.com")
    @NotNull(message = "Email must be not null.")
    @Email
    private String email;

    @Schema(description = "User encrypted password")
    @NotNull(message = "Password must be not null.")
    private String password;

}
