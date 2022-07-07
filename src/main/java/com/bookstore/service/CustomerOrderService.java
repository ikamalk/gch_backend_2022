package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.CustomerOrder;

public interface CustomerOrderService {

    List<CustomerOrder> getAllCustomerOrders();

    CustomerOrder geCustomerOrderById(Long id);

    Boolean deleteCustomerOrderById(Long id);

    Boolean updateCustomerOrderById(Long id, CustomerOrder customerOrder);

    CustomerOrder creatCustomerOrder(CustomerOrder customerOrder);
}
