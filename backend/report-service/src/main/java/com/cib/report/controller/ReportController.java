package com.cib.report.controller;

import com.cib.report.dto.StatementResponse;
import com.cib.report.dto.TransactionReport;
import com.cib.report.service.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping("/statement/{accountNumber}")
    public StatementResponse getStatement(
            @PathVariable String accountNumber) {

        return service.generateStatement(
                accountNumber);
    }

    @GetMapping("/transactions/{accountNumber}")
    public List<TransactionReport> getTransactions(
            @PathVariable String accountNumber) {

        return service.getTransactions(
                accountNumber);
    }

    @GetMapping("/download/{accountNumber}")
    public String downloadPdf(
            @PathVariable String accountNumber) {

        return service.downloadPdf(
                accountNumber);
    }
        @GetMapping("/export/csv/{accountNumber}")
        public String exportCsv(
                @PathVariable String accountNumber) {

        return service.exportCsv(
                accountNumber);
        }
}