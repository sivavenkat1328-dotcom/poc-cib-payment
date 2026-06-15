package com.cib.gateway.security;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter
        extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {

        return (exchange, chain) -> {

            String token =
                    exchange.getRequest()
                            .getHeaders()
                            .getFirst("Authorization");

            System.out.println(
                    "JWT Token : " + token);

            return chain.filter(exchange);
        };
    }
}