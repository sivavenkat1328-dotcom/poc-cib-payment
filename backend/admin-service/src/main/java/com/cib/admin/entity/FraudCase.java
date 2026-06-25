package com.cib.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name="fraud_cases")
public class FraudCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long transactionId;

    private String reason;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getTransactionId(){
        return transactionId;
    }

    public void setTransactionId(Long transactionId){
        this.transactionId=transactionId;
    }

    public String getReason(){
        return reason;
    }

    public void setReason(String reason){
        this.reason=reason;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

}