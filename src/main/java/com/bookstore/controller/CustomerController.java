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

import com.bookstore.entity.Customer;
import com.bookstore.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("api/v1/customer")
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

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteCustomerById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    customerServiceImpl.deleteCustomerById((long) id) ? 
                    "Customer Deleted Successfully" 
                    :
                    "Customer not found"
                );
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> updateCustomerById(@PathVariable int id, @RequestBody Customer customer) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                    customerServiceImpl.updateCustomerById((long) id, customer) ?
                    "Customer Updated Successfully" 
                    : 
                    "Customer Not Found"
                );
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerServiceImpl.creatCustomer(customer));
    }
}
