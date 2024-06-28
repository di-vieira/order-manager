package com.diego.study.ordermanager.controller;

import com.diego.study.ordermanager.model.Order;
import com.diego.study.ordermanager.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService OrderService;

    @GetMapping(value = "/test")
    public String healthChech() {
        return "/orders REST is working";
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "List all Orders")
    public ResponseEntity<Order> findOrder(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(OrderService.getOrder(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
