package com.cib.report.csv;

import com.cib.report.dto.TransactionReport;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class CsvGenerator {

    public String generateCsv(
            String accountNumber,
            List<TransactionReport> transactions) {

        String fileName =
                "transactions-"
                        + accountNumber
                        + ".csv";

        try (FileWriter writer =
                     new FileWriter(fileName)) {

            writer.append(
                    "Transaction ID,Account Number,Amount,Type,Status,Date\n");

            for (TransactionReport transaction
                    : transactions) {

                writer.append(
                                transaction.getTransactionId())
                        .append(",")

                        .append(transaction.getAccountNumber())
                        .append(",")

                        .append(String.valueOf(
                                transaction.getAmount()))
                        .append(",")

                        .append(transaction.getTransactionType())
                        .append(",")

                        .append(transaction.getStatus())
                        .append(",")

                        .append(transaction.getTransactionDate())
                        .append("\n");
            }

            writer.flush();

            return fileName;

        } catch (IOException ex) {

            throw new RuntimeException(
                    "CSV Generation Failed : "
                            + ex.getMessage());
        }
    }
}