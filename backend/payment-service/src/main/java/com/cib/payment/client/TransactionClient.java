package com.cib.payment.client;

import com.cib.payment.dto.TransactionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "transaction-service",
        url = "http://localhost:8087")
public interface TransactionClient {

    @PostMapping("/api/transactions")
    Object createTransaction(
            @RequestBody TransactionRequest request);
}