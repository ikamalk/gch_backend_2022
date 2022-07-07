package com.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.CustomerOrder;
import com.bookstore.repository.CustomerOrderRepository;
import com.bookstore.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Override
    public List<CustomerOrder> getAllCustomerOrderServices() {
        return customerOrderRepository.findAll();
    }

    @Override
    public CustomerOrder geCustomerOrderServiceById(Long id) {
        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);

        if(customerOrder.isPresent()) {
            return customerOrder.get();
        }

        return null;
    }
}
