package com.example.book_sellls.domain.repository.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "BOOK_NAME", length = 100)
    private String bookName;

    @Column(name = "BOOK_AUTHOR", length = 100)
    private String bookAuthor;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "book_resume")
    private String bookResume;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "ISBN")
    private String ISBN;


}
