package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.Publisher;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    Publisher getPublisherById(Long id);
}
