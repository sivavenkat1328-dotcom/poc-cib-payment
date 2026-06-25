package com.cib.admin.dto;

public class FreezeAccountRequest {

    private Long accountId;

    private String remarks;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId){
        this.accountId=accountId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks=remarks;
    }

}