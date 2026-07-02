package com.cib.ai.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getTransactions() {

        return restTemplate.getForObject(
                "http://TRANSACTION-SERVICE/api/transactions",
                Object.class);
    }
}