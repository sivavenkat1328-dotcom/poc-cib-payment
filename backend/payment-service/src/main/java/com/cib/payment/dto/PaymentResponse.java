package com.cib.payment.dto;

public class PaymentResponse {

    private String paymentId;

    private String transactionId;

    private String status;

    private String message;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(
            String paymentId) {

        this.paymentId = paymentId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(
            String transactionId) {

        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {

        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(
            String message) {

        this.message = message;
    }
}