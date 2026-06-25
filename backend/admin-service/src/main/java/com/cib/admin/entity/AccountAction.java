package com.cib.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name="account_actions")
public class AccountAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;

    private String action;

    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getAccountId(){
        return accountId;
    }

    public void setAccountId(Long accountId){
        this.accountId=accountId;
    }

    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action=action;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks=remarks;
    }

}