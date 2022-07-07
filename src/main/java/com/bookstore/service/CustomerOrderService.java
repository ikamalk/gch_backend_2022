package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.CustomerOrder;

public interface CustomerOrderService {

    List<CustomerOrder> getAllCustomerOrderServices();

    CustomerOrder geCustomerOrderServiceById(Long id);
}
