package com.diego.study.ordermanager.model;

import com.diego.study.ordermanager.model.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class PaymentBankSlip extends Payment  {

    private LocalDate expirationDate;
    private LocalDateTime paymentDate;

    public PaymentBankSlip(){

    }
    public PaymentBankSlip(LocalDate expirationDate, LocalDateTime paymentDate) {
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public PaymentBankSlip(Integer id, PaymentStatus paymentStatus, Order order, LocalDate expirationDate, LocalDateTime paymentDate) {
        super(id, paymentStatus, order);
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }


}
