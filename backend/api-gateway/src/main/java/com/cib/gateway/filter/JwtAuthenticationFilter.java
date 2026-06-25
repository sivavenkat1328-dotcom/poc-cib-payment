package com.cib.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter
        extends AbstractGatewayFilterFactory<Object> {

    public JwtAuthenticationFilter() {
        super(Object.class);
    }

    @Override
    public GatewayFilter apply(Object config) {

        return (exchange, chain) -> {

            String path =
                    exchange.getRequest()
                            .getURI()
                            .getPath();

            if (path.contains("/swagger-ui")
                    || path.contains("/v3/api-docs")) {

                return chain.filter(exchange);
            }

            String token =
                    exchange.getRequest()
                            .getHeaders()
                            .getFirst("Authorization");

            if (token == null
                    || !token.startsWith("Bearer ")) {

                exchange.getResponse()
                        .setStatusCode(
                                HttpStatus.UNAUTHORIZED);

                return exchange.getResponse()
                        .setComplete();
            }

            return chain.filter(exchange);
        };
    }
}