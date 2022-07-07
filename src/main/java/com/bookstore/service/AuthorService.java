package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.Author;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);
}
