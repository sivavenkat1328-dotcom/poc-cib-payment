package com.cib.admin.service;

import com.cib.admin.dto.DashboardStats;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public DashboardStats getDashboardStats(){

        DashboardStats stats = new DashboardStats();

        stats.setTotalCustomers(150L);

        stats.setTotalAccounts(250L);

        stats.setTotalTransactions(850L);

        stats.setTotalFrauds(5L);

        return stats;
    }

}