package com.cib.ai.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getPayments() {

        return restTemplate.getForObject(
                "http://PAYMENT-SERVICE/api/payments",
                Object.class);
    }
}