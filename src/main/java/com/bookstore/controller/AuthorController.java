package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Author;
import com.bookstore.serviceImpl.AuthorServiceImpl;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @GetMapping
    @ResponseBody
    public List<Author> getAllAuthors() {
        return authorServiceImpl.getAllAuthors();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Author getAuthorById(@PathVariable int id) {
        return authorServiceImpl.getAuthorById((long) id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteAuthorById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    authorServiceImpl.deleteAuthorById((long) id) ? 
                        "Author Deleted Successfully" : "Author could not be delete at this time"
                );
    }


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> updateAuthorById(@PathVariable int id, @RequestBody Author author) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(authorServiceImpl.updateAuthorById((long) id, author));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(authorServiceImpl.createAuthor(author));
    }
}
