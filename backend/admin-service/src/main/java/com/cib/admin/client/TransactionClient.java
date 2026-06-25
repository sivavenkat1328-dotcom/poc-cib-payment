package com.cib.admin.client;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

@Component

public class TransactionClient {

    @Autowired

    private RestTemplate restTemplate;

    private static final String BASE_URL =

            "http://TRANSACTION-SERVICE/api/transactions";


    public Object getAllTransactions(){

        return restTemplate.getForObject(

                BASE_URL,

                Object.class);

    }


    public Object getTransaction(Long id){

        return restTemplate.getForObject(

                BASE_URL + "/" + id,

                Object.class);

    }

}