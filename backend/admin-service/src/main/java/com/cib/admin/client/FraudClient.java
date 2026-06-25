package com.cib.admin.client;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

@Component

public class FraudClient {

    @Autowired

    private RestTemplate restTemplate;

    private static final String BASE_URL =

            "http://FRAUD-DETECTION-SERVICE/api/fraud";


    public Object getAllFraudCases(){

        return restTemplate.getForObject(

                BASE_URL,

                Object.class);

    }


    public Object getFraudCase(Long id){

        return restTemplate.getForObject(

                BASE_URL + "/" + id,

                Object.class);

    }

}