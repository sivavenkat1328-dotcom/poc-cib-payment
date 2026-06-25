package com.cib.report.dto;

public class TransactionReport {

    private String transactionId;

    private String accountNumber;

    private Double amount;

    private String transactionType;

    private String status;

    private String transactionDate;

    public TransactionReport() {
    }

    public TransactionReport(
            String transactionId,
            String accountNumber,
            Double amount,
            String transactionType,
            String status,
            String transactionDate) {

        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.status = status;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(
            String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(
            String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(
            Double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(
            String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {
        this.status = status;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(
            String transactionDate) {
        this.transactionDate = transactionDate;
    }
}