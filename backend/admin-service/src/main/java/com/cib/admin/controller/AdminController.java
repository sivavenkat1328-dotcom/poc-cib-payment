package com.cib.admin.controller;

import com.cib.admin.client.AccountClient;
import com.cib.admin.client.CustomerClient;
import com.cib.admin.client.FraudClient;
import com.cib.admin.client.TransactionClient;
import com.cib.admin.dto.DashboardStats;
import com.cib.admin.dto.FreezeAccountRequest;
import com.cib.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private TransactionClient transactionClient;

    @Autowired
    private FraudClient fraudClient;

    @GetMapping("/dashboard")
    public DashboardStats getDashboard() {
        return adminService.getDashboardStats();
    }

    @GetMapping("/customers")
    public Object getCustomers() {
        return customerClient.getAllCustomers();
    }

    @GetMapping("/transactions")
    public Object getTransactions() {
        return transactionClient.getAllTransactions();
    }

    @GetMapping("/fraud-cases")
    public Object getFraudCases() {
        return fraudClient.getAllFraudCases();
    }

    @PostMapping("/freeze")
    public String freezeAccount(
            @RequestBody FreezeAccountRequest request) {

        return accountClient.freezeAccount(
                request.getAccountId());
    }

    @PostMapping("/unfreeze/{id}")
    public String unfreezeAccount(
            @PathVariable Long id) {

        return accountClient.unfreezeAccount(id);
    }
}