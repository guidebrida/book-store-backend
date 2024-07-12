package com.example.book_sellls.domain.repository.repository;

import com.example.book_sellls.domain.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clients extends JpaRepository<Client, Integer> {
}
