package com.diego.study.ordermanager.service;

import com.diego.study.ordermanager.exception.ResourceNotFound;
import com.diego.study.ordermanager.model.Order;
import com.diego.study.ordermanager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
   
    @Autowired
    private OrderRepository OrderRepository;

    public Order getOrder(Integer id) {
        return OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Order id " + id + " not found. - " + Order.class.getName()));
    }
}
