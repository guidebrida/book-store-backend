package com.example.book_sellls.domain.repository.repository;

import com.example.book_sellls.domain.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Books extends JpaRepository<Book, Integer> {

}
