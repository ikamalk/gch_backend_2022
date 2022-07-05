package com.bookstore.service;

import com.bookstore.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    public List<Book> findAllBooks();

    public Book findBookById(Long id);
}
