package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
