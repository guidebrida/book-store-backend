package com.example.book_sellls.controller;

import com.example.book_sellls.domain.repository.entity.Book;
import com.example.book_sellls.domain.repository.entity.Client;
import com.example.book_sellls.domain.repository.repository.Clients;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    private Clients clients;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return clients.save(client);
    }

    @GetMapping("{id}")
    public Client getClientByid(@PathVariable
                                @ApiParam("Client id") Integer clientID) {
        return clients.findById(clientID)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Client not found"));
    }

    @GetMapping
    public List<Client> find(Book filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter, matcher);
        return clients.findAll(example);
    }

    @DeleteMapping("{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer clientId) {
        clients.findById(clientId)
                .map(client -> {
                    clients.delete(client);
                    return client;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Client not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Client client) {
        clients.findById(id).map(clienteExistente -> {
            client.setId(clienteExistente.getId());
            clients.save(client);
            return clienteExistente;
        }).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Client not found"));
    }

}
