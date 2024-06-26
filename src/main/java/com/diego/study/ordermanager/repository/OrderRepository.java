package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
}
