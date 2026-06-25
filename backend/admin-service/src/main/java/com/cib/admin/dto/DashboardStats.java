package com.cib.admin.dto;

public class DashboardStats {

    private Long totalCustomers;

    private Long totalAccounts;

    private Long totalTransactions;

    private Long totalFrauds;

    public Long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(Long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public Long getTotalAccounts() {
        return totalAccounts;
    }

    public void setTotalAccounts(Long totalAccounts) {
        this.totalAccounts = totalAccounts;
    }

    public Long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Long getTotalFrauds() {
        return totalFrauds;
    }

    public void setTotalFrauds(Long totalFrauds) {
        this.totalFrauds = totalFrauds;
    }

}