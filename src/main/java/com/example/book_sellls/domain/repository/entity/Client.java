package com.example.book_sellls.domain.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CPF")
    private String Cpf;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
