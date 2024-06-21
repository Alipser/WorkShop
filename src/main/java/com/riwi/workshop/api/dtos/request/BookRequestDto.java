package com.riwi.workshop.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    private Integer id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title must be less than or equal to 100 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(max = 100, message = "Author must be less than or equal to 100 characters")
    private String author;

    @NotNull(message = "Publication year is mandatory")
    @Positive(message = "Publication year can't be negative")
    private Integer publicationYear;

    @Size(max = 50, message = "Genre must be less than or equal to 50 characters")
    private String genre;

    @Size(max = 20, message = "ISBN must be less than or equal to 20 characters")
    private String isbn;
}