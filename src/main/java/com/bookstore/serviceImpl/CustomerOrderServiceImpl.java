package com.bookstore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookstore.entity.CustomerOrder;
import com.bookstore.repository.CustomerOrderRepository;
import com.bookstore.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Override
    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderRepository.findAll();
    }

    @Override
    public CustomerOrder geCustomerOrderById(Long id) {
        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);

        if(customerOrder.isPresent()) {
            return customerOrder.get();
        }

        return null;
    }

    @Override
    public Boolean deleteCustomerOrderById(Long id) {
        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);

        if(customerOrder.isPresent()) {
            customerOrderRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Boolean updateCustomerOrderById(Long id, CustomerOrder customerOrder) {
        try {
            Optional<CustomerOrder> customerOrderCheck = customerOrderRepository.findById(id);

            if(customerOrderCheck.isPresent()) {
                customerOrderRepository.save(customerOrder);
                return true;
            }

            return false;
        } catch (Exception err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Customer Order could not update in this time",
                err
            );
        }
    }

    @Override
    public CustomerOrder creatCustomerOrder(CustomerOrder customerOrder) {
        try {
            return customerOrderRepository.save(customerOrder);
        } catch (Exception err) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Customer could not create at this time",
                err
            );
        }
    }
}
