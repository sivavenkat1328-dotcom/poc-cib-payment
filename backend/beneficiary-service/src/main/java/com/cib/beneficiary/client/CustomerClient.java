package com.cib.beneficiary.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getCustomer(
            String customerId) {

        return restTemplate.getForObject(
                "http://CUSTOMER-SERVICE/api/customers/customer-id?customerId="
                        + customerId,
                Object.class);
    }
}