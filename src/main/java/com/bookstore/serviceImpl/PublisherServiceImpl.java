package com.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookstore.entity.Publisher;
import com.bookstore.repository.PublisherRepository;
import com.bookstore.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);

        if(publisher.isPresent()) {
            return publisher.get();
        }
        return null;
    }

    @Override
    public Boolean deletePublisherById(Long id) {
        Optional<Publisher> publisher = publisherRepository.findById(id);

        if(publisher.isPresent()) {
            publisherRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Boolean updatePublisherById(Long id, Publisher publisher) {
        try {
            Optional<Publisher> publisherCheck = publisherRepository.findById(id);

            if(publisherCheck.isPresent()) {
                publisherRepository.save(publisher);
                return true;
            }

            return false;
        } catch (ResponseStatusException err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Publisher could not update at this time",
                err
            );
        }
    }

    @Override
    public Publisher creatPublisher(Publisher publisher) {
        try {
            return publisherRepository.save(publisher);
        } catch (ResponseStatusException err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Publisher could not create at this time",
                err
            );
        }
    }
}
