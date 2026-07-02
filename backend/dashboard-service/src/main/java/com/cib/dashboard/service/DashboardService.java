package com.cib.dashboard.service;

import com.cib.dashboard.dto.DashboardSummary;
import com.cib.dashboard.dto.FraudSummary;
import com.cib.dashboard.dto.PaymentTrend;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    public DashboardSummary getSummary() {

        DashboardSummary summary =
                new DashboardSummary();

        summary.setTotalCustomers(2L);
        summary.setTotalAccounts(5L);
        summary.setTotalPayments(20L);
        summary.setTotalTransactions(20L);
        summary.setTotalFrauds(1L);

        return summary;
    }

    public List<PaymentTrend> getPaymentTrends() {

        List<PaymentTrend> trends =
                new ArrayList<>();

        trends.add(
                new PaymentTrend("JAN", 10L));

        trends.add(
                new PaymentTrend("FEB", 20L));

        trends.add(
                new PaymentTrend("MAR", 35L));

        trends.add(
                new PaymentTrend("APR", 40L));

        return trends;
    }

    public FraudSummary getFraudSummary() {

        FraudSummary summary =
                new FraudSummary();

        summary.setApproved(120L);
        summary.setRejected(5L);
        summary.setUnderReview(2L);

        return summary;
    }
}