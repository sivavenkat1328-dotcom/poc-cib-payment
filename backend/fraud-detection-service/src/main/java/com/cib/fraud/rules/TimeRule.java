package com.cib.fraud.rules;

import org.springframework.stereotype.Component;

@Component
public class TimeRule {

    public int evaluate(String time) {

        if (time == null) {
            return 0;
        }

        if (time.startsWith("23")
                || time.startsWith("00")
                || time.startsWith("01")) {

            return 20;
        }

        return 5;
    }
}