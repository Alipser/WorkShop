package com.riwi.workshop.api.dtos.request;

import com.riwi.workshop.utils.enums.RoleType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    
    private Integer id;

    @NotBlank(message = "Username is mandatory")
    @Size(max = 50, message = "Username must be less than or equal to 50 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(max = 100, message = "Password must be less than or equal to 100 characters")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
    private String email;

    @NotBlank(message = "Full name is mandatory")
    @Size(max = 100, message = "Full name must be less than or equal to 100 characters")
    private String fullName;

    @NotNull(message = "Role is mandatory")
    private RoleType role;
}
