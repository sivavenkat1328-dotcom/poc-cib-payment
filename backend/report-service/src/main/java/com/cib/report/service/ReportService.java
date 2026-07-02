package com.cib.report.service;

import com.cib.report.csv.CsvGenerator;
import com.cib.report.dto.StatementResponse;
import com.cib.report.dto.TransactionReport;
import com.cib.report.exception.ReportNotFoundException;
import com.cib.report.pdf.PdfGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private CsvGenerator csvGenerator;

    public StatementResponse generateStatement(
            String accountNumber) {

        if (accountNumber == null ||
                accountNumber.isBlank()) {

            throw new ReportNotFoundException(
                    "Account Statement",
                    "UNKNOWN");
        }

        StatementResponse response =
                new StatementResponse();

        response.setReportName(
                "Account Statement");

        response.setStatus(
                "Generated Successfully");

        response.setGeneratedDate(
                LocalDate.now().toString());

        return response;
    }

    public List<TransactionReport> getTransactions(
            String accountNumber) {

        List<TransactionReport> reports =
                new ArrayList<>();

        reports.add(
                new TransactionReport(
                        "TXN1001",
                        accountNumber,
                        5000.0,
                        "CREDIT",
                        "SUCCESS",
                        LocalDate.now().toString()));

        reports.add(
                new TransactionReport(
                        "TXN1002",
                        accountNumber,
                        2500.0,
                        "DEBIT",
                        "SUCCESS",
                        LocalDate.now().toString()));

        return reports;
    }

    public String downloadPdf(
            String accountNumber) {

        if (accountNumber == null ||
                accountNumber.isBlank()) {

            throw new ReportNotFoundException(
                    "PDF Statement",
                    "UNKNOWN");
        }

        return pdfGenerator.generatePdf(
                accountNumber);
    }

    public String exportCsv(
            String accountNumber) {

        if (accountNumber == null ||
                accountNumber.isBlank()) {

            throw new ReportNotFoundException(
                    "CSV Report",
                    "UNKNOWN");
        }

        return csvGenerator.generateCsv(
                accountNumber,
                getTransactions(accountNumber));
    }
}