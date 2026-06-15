package com.cib.fraud.rules;

import org.springframework.stereotype.Component;

@Component
public class AmountRule {

    public int evaluate(Double amount) {

        if (amount == null) {
            return 0;
        }

        if (amount >= 500000) {
            return 50;
        }

        if (amount >= 100000) {
            return 25;
        }

        return 5;
    }
}