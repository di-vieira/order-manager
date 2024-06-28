package com.diego.study.ordermanager.model;

import com.diego.study.ordermanager.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class PaymentBankSlip extends Payment  {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate expirationDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
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
