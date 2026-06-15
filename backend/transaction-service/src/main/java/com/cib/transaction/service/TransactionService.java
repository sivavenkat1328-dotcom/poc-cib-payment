package com.cib.transaction.service;

import com.cib.transaction.dto.TransactionRequest;
import com.cib.transaction.dto.TransactionResponse;
import com.cib.transaction.entity.Transaction;
import com.cib.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public TransactionResponse create(
            TransactionRequest request) {

        Transaction transaction =
                new Transaction();

        String txnId =
                "TXN-" + System.currentTimeMillis();

        transaction.setTransactionId(txnId);
        transaction.setFromAccount(
                request.getFromAccount());

        transaction.setToAccount(
                request.getToAccount());

        transaction.setAmount(
                request.getAmount());

        transaction.setTransactionType(
                request.getTransactionType());

        transaction.setStatus("SUCCESS");

        transaction.setTransactionDate(
                LocalDateTime.now());

        repository.save(transaction);

        TransactionResponse response =
                new TransactionResponse();

        response.setTransactionId(txnId);
        response.setStatus("SUCCESS");
        response.setMessage(
                "Transaction Recorded Successfully");

        return response;
    }

    public Transaction getByTransactionId(
            String transactionId) {

        return repository
                .findByTransactionId(transactionId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Transaction Not Found"));
    }
}