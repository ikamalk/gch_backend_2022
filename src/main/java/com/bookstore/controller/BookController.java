package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.serviceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @GetMapping
    public @ResponseBody List<Book> getBooks(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Book> bookPage = bookServiceImpl.findAllBooks(pageable).toList();
        return bookPage;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Book getBookById(@PathVariable int id) {
        return bookServiceImpl.findBookById((long)id);
    }
}
