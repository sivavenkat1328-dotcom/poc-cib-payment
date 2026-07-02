package com.cib.report.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccountClient {

    @Autowired
    private RestTemplate restTemplate;

    public Object getAccounts() {

        return restTemplate.getForObject(
                "http://ACCOUNT-SERVICE/api/accounts",
                Object.class);
    }
}