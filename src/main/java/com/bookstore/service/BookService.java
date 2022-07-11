package com.bookstore.service;

import com.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {


    Page<Book> findAllBooks(Pageable pageable);

    public Book findBookById(Long id);
}
