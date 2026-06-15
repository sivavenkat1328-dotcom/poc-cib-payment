package com.cib.fraud.rules;

import org.springframework.stereotype.Component;

@Component
public class LocationRule {

    public int evaluate(String location) {

        if (location == null) {
            return 0;
        }

        if ("International".equalsIgnoreCase(location)) {
            return 30;
        }

        return 5;
    }
}