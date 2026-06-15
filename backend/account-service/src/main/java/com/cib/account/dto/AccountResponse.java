package com.cib.account.dto;

public class AccountResponse {

    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private Double balance;

    public AccountResponse() {
    }

    public AccountResponse(Long id,
                           String accountNumber,
                           String accountHolderName,
                           Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }
}