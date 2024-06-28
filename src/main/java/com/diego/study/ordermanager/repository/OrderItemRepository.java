package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer> {
}
