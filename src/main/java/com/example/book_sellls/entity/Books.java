package com.example.book_sellls.entity;
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
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String bookname;

    @Column(name = "book_author", length = 100)
    private String bookAuthor;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "book_resume")
    private String bookResume;

    @Column(name = "price")
    private BigDecimal price;

}
