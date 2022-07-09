package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.serviceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @GetMapping
    public @ResponseBody List<Book> getBooks() {
        return bookServiceImpl.findAllBooks();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Book getBookById(@PathVariable int id) {
        return bookServiceImpl.findBookById((long)id);
    }
}
