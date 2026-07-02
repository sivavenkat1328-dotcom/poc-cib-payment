package com.cib.customer.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditConfig {

    public AuditConfig() {

        System.out.println(
                "Customer Service Audit Configuration Loaded");
    }
}