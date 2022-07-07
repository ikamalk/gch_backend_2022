package com.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
