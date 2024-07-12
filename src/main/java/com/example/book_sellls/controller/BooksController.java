package com.example.book_sellls.controller;

import com.example.book_sellls.domain.repository.entity.Book;
import com.example.book_sellls.domain.repository.repository.Books;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BooksController {

    private Books books;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return books.save(book);
    }

    @GetMapping("{id}")
    public Book getBookByid(@PathVariable
                            @ApiParam("Book id") Integer bookId) {
        return books.findById(bookId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Book not found"));
    }

    @GetMapping
    public List<Book> find(Book filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter, matcher);
        return books.findAll(example);
    }

    @DeleteMapping("{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer bookId) {
        books.findById(bookId)
                .map(book -> {
                    books.delete(book);
                    return book;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Book not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Book book) {
        books.findById(id).map(clienteExistente -> {
            book.setId(clienteExistente.getId());
            books.save(book);
            return clienteExistente;
        }).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Book not found"));
    }
}
