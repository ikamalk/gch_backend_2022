package com.bookstore.controller;

import com.bookstore.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/")
public class MainController {


    @GetMapping
    public @ResponseBody String welcome() {
        return "Welcome to the bookstore server";
    }
}
