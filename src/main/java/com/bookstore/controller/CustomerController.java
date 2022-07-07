package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Customer;
import com.bookstore.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @GetMapping
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerServiceImpl.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable int id) {
        return customerServiceImpl.getCustomerById((long) id);
    }
}
