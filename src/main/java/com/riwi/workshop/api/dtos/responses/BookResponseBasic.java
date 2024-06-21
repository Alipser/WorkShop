package com.riwi.workshop.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseBasic {

    private Integer id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String genre;
    private String isbn;

    
}