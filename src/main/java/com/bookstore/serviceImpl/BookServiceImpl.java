package com.bookstore.serviceImpl;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        Book book;
        if(bookRepository.findById(id).isPresent()){
            book = bookRepository.findById(id).get();
        } else {
            book = null;
        }
        return book;
    }
}
