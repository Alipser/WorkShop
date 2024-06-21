package com.riwi.workshop.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "isbn", length = 20)
    private String isbn;

    @OneToMany(mappedBy = "book")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;
}