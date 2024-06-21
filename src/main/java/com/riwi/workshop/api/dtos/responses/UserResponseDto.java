package com.riwi.workshop.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.riwi.workshop.utils.enums.RoleType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private RoleType role;

    private List<LoanResponseDto> loans;
    private List<ReservationResponseDto> reservations;
}
