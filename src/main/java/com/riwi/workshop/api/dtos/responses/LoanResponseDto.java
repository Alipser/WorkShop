package com.riwi.workshop.api.dtos.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDto {

    private Integer id;
    private Date loanDate;
    private Date returnDate;
    private String status;

    private UserResponseBasic user;
    private BookResponseBasic book;
}