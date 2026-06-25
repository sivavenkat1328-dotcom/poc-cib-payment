package com.cib.admin.client;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

@Component

public class CustomerClient {

    @Autowired

    private RestTemplate restTemplate;

    private static final String BASE_URL =

            "http://CUSTOMER-SERVICE/api/customers";


    public Object getAllCustomers(){

        return restTemplate.getForObject(

                BASE_URL,

                Object.class);

    }


    public Object getCustomerById(Long id){

        return restTemplate.getForObject(

                BASE_URL + "/" + id,

                Object.class);

    }

}