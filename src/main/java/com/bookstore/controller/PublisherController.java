package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePublisherById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    publisherServiceImpl.deletePublisherById((long) id) ?
                    "Publisher Deleted Successfully" :
                    "Publisher not found"
                );
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> updatePublisherById(@PathVariable Long id, @RequestBody Publisher publisher) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    publisherServiceImpl.updatePublisherById((long) id, publisher) ?
                    "Publisher Updated Successfully" : 
                    "Publisher Not Found"
                );
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(publisherServiceImpl.creatPublisher(publisher));
    }
}
