package com.cib.scheduledpayment.dto;

public class ScheduledPaymentResponse {

    private Long id;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private String scheduleDate;
    private String executionTime;
    private String frequency;
    private String status;

    public ScheduledPaymentResponse() {
    }

    public ScheduledPaymentResponse(Long id,
                                    String fromAccount,
                                    String toAccount,
                                    Double amount,
                                    String scheduleDate,
                                    String executionTime,
                                    String frequency,
                                    String status) {
        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.scheduleDate = scheduleDate;
        this.executionTime = executionTime;
        this.frequency = frequency;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}