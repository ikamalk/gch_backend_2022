package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.Publisher;

public interface PublisherService {

    List<Publisher> getAllPublishers();

    Publisher getPublisherById(Long id);

    Boolean deletePublisherById(Long id);

    Boolean updatePublisherById(Long id, Publisher publisher);

    Publisher creatPublisher(Publisher publisher);
}
