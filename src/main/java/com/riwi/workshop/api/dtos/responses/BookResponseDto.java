package com.riwi.workshop.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String genre;
    private String isbn;

    private List<LoanResponseDto> loans;
    private List<ReservationResponseDto> reservations;
}