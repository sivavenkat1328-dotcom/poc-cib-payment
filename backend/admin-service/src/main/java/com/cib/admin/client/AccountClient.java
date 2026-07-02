package com.cib.admin.client;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

@Component

public class AccountClient {

    @Autowired

    private RestTemplate restTemplate;

    private static final String BASE_URL =

            "http://ACCOUNT-SERVICE/api/accounts";


    public Object getAllAccounts(){

        return restTemplate.getForObject(

                BASE_URL,

                Object.class);

    }


    public Object getAccount(Long id){

        return restTemplate.getForObject(

                BASE_URL + "/" + id,

                Object.class);

    }


    public String freezeAccount(Long id){

        return restTemplate.postForObject(

                BASE_URL + "/freeze/" + id,

                null,

                String.class);

    }


    public String unfreezeAccount(Long id){

        return restTemplate.postForObject(

                BASE_URL + "/unfreeze/" + id,

                null,

                String.class);

    }

}