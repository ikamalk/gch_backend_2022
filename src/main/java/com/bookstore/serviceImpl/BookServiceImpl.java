package com.bookstore.serviceImpl;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {
    @Autowired
    BookRepository bookRepository;



    @Override
    public Page<Book> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
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
