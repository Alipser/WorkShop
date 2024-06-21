package com.riwi.workshop.domain.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import com.riwi.workshop.utils.enums.StatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loan_date", nullable = false)
    private Date loanDate;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    @Column(name = "status", nullable = false, length = 20)
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;
}