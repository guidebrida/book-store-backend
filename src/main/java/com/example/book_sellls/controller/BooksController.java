package com.example.book_sellls.controller;

import com.example.book_sellls.entity.Books;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/api/books")
public class BooksController {

//    @PostMapping
//    @ResponseStatus(CREATED)
//    public Integer save( @RequestBody  dto ){
//        Books books = service.salvar(dto);
//        return books.getId();
//    }

}
