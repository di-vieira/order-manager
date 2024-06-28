package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
