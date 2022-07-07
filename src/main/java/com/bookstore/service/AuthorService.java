package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.Author;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Boolean deleteAuthorById(Long id);

    String updateAuthorById(Long id, Author author);
    
    Author createAuthor(Author author);
}
