package com.diego.study.ordermanager.model;

import com.diego.study.ordermanager.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

    private static final long serialVersionUUID = 1L;

    @Id
    private Integer id;
    private PaymentStatus paymentStatus;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    public Payment(){

    }

    public Payment(Integer id, PaymentStatus paymentStatus, Order order) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
