package com.riwi.workshop.api.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDto {

    private Integer id;
    private Date reservationDate;
    private String status;

    private UserResponseBasic user;
    private BookResponseBasic book;
}