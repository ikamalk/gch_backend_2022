package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.Customer;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Boolean deleteCustomerById(Long id);

    Boolean updateCustomerById(Long id, Customer customer);

    Customer creatCustomer(Customer customer); 
}
