package com.diego.study.ordermanager.model;

import com.diego.study.ordermanager.model.enums.PaymentStatus;
import jakarta.persistence.Entity;

@Entity
public class PaymentCreditCard extends Payment {

    private Integer installmentsNumber;

    public PaymentCreditCard(){

    }
    public PaymentCreditCard(Integer installmentsNumber) {
        this.installmentsNumber = installmentsNumber;
    }

    public PaymentCreditCard(Integer id, PaymentStatus paymentStatus, Order order, Integer installmentsNumber) {
        super(id, paymentStatus, order);
        this.installmentsNumber = installmentsNumber;
    }

    public Integer getInstallmentsNumber() {
        return installmentsNumber;
    }

    public void setInstallmentsNumber(Integer installmentsNumber) {
        this.installmentsNumber = installmentsNumber;
    }

}
