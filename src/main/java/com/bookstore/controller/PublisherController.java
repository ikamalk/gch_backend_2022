package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Publisher;
import com.bookstore.serviceImpl.PublisherServiceImpl;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    @Autowired
    PublisherServiceImpl publisherServiceImpl;

    @GetMapping
    @ResponseBody
    public List<Publisher> getAllPublishers() {
        return publisherServiceImpl.getAllPublishers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherServiceImpl.getPublisherById((long) id);
    }
}
