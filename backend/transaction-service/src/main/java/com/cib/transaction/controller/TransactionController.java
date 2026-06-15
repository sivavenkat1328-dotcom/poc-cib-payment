package com.cib.transaction.controller;

import com.cib.transaction.dto.TransactionRequest;
import com.cib.transaction.dto.TransactionResponse;
import com.cib.transaction.entity.Transaction;
import com.cib.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public TransactionResponse create(
            @RequestBody TransactionRequest request) {

        return service.create(request);
    }

    @GetMapping("/{transactionId}")
    public Transaction getByTransactionId(
            @PathVariable String transactionId) {

        return service.getByTransactionId(transactionId);
    }
}