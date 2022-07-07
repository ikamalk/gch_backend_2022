package com.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookstore.entity.Author;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        if(author.isPresent()) {
            return author.get();
        }

        return null;
    }

    @Override
    public Boolean deleteAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        if(author.isPresent()) {
            authorRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Boolean updateAuthorById(Long id, Author author) {
        try {
            Optional<Author> authorCheck = authorRepository.findById(id);

            if(authorCheck.isPresent()) {
                authorRepository.save(author);
                return true;
            }

            return false;
        } catch (Exception err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Author could not update at this time",
                err
            );
        }
    }

    @Override
    public Author createAuthor(Author author) {
        try {
            return authorRepository.save(author);
        } catch (Exception err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Author could not create at this time",
                err
            );
        }
    }
}
