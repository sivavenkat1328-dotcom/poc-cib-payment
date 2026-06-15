package com.cib.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoutes(
            RouteLocatorBuilder builder) {

        return builder.routes()

                .route("account-service",
                        r -> r.path("/api/accounts/**")
                                .uri("lb://ACCOUNT-SERVICE"))

                .route("payment-service",
                        r -> r.path("/api/payments/**")
                                .uri("lb://PAYMENT-SERVICE"))

                .route("fraud-service",
                        r -> r.path("/api/fraud/**")
                                .uri("lb://FRAUD-DETECTION-SERVICE"))

                .route("ai-service",
                        r -> r.path("/api/chat/**")
                                .uri("lb://AI-SERVICE"))

                .build();
    }
}