package com.riwi.workshop.api.dtos.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.riwi.workshop.utils.enums.StatusType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {

    private Integer id;

    @NotNull(message = "Reservation date is mandatory")
    @FutureOrPresent(message = "Reservation date must be in a near future or today")
    private Date reservationDate;

    @NotBlank(message = "Status is mandatory")
    private StatusType status;

    @NotNull(message = "User ID is mandatory")
    private Integer userId;

    @NotNull(message = "Book ID is mandatory")
    private Integer bookId;
}
