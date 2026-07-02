package com.cib.report.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getCustomers() {

        return restTemplate.getForObject(
                "http://CUSTOMER-SERVICE/api/customers",
                Object.class);
    }

    public Object getCustomer(
            String customerId) {

        return restTemplate.getForObject(
                "http://CUSTOMER-SERVICE/api/customers/"
                        + customerId,
                Object.class);
    }
}