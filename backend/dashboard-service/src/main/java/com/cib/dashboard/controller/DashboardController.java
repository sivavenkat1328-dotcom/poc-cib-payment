package com.cib.dashboard.controller;

import com.cib.dashboard.dto.DashboardSummary;
import com.cib.dashboard.dto.FraudSummary;
import com.cib.dashboard.dto.PaymentTrend;
import com.cib.dashboard.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("/summary")
    public DashboardSummary getSummary() {

        return service.getSummary();
    }

    @GetMapping("/payment-trends")
    public List<PaymentTrend> getPaymentTrends() {

        return service.getPaymentTrends();
    }

    @GetMapping("/fraud-summary")
    public FraudSummary getFraudSummary() {

        return service.getFraudSummary();
    }
}