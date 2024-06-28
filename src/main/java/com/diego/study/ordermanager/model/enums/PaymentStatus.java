package com.diego.study.ordermanager.model.enums;

public enum PaymentStatus {

    OUTSTANDING(1, "Outstanding"),
    DONE(2, "Done"),
    CANCELLED(3, "Cancelled");

    private Integer paymentStatusCode;
    private String paymentStatusDescription;

    PaymentStatus(Integer paymentStatusCode, String paymentStatusDescription) {
        this.paymentStatusCode = paymentStatusCode;
        this.paymentStatusDescription = paymentStatusDescription;
    }

    public Integer getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public String getPaymentStatusDescription() {
        return paymentStatusDescription;
    }

    public static PaymentStatus toEnum(Integer paymentStatusCode) {
        if (paymentStatusCode == null){
            return null;
        }

        for (PaymentStatus paymentStatus : PaymentStatus.values()){
            if (paymentStatusCode.equals(paymentStatus.getPaymentStatusCode())) {
                return paymentStatus;
            }
        }
        throw new IllegalArgumentException("Invalid client type code");
    }
}
