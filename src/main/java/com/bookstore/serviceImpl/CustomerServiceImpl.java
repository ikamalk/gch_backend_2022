package com.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookstore.entity.Customer;
import com.bookstore.repository.CustomerRepository;
import com.bookstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()) {
            return customer.get();
        }

        return null;
    }

    @Override
    public Boolean deleteCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Boolean updateCustomerById(Long id, Customer customer) {
        try {
            Optional<Customer> customerCheck = customerRepository.findById(id);

            if(customerCheck.isPresent()) {
                customerRepository.save(customer);
                return true;
            }

            return false;
        } catch (ResponseStatusException err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Customer could not update at this time",
                err
            );
        }
    }

    @Override
    public Customer creatCustomer(Customer customer) {
        try {
            return customerRepository.save(customer);
        } catch (ResponseStatusException err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Customer could not update at this time",
                err
            );
        }
    }
}
