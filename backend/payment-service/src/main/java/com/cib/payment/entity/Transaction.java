package com.cib.payment.entity;

public class Transaction {

    private Long id;
    private String beneficiary;
    private Double amount;
    private String status;

    public Transaction() {
    }

    public Transaction(Long id,
                       String beneficiary,
                       Double amount,
                       String status) {
        this.id = id;
        this.beneficiary = beneficiary;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public Double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}