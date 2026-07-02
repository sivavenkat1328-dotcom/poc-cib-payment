package com.cib.common.util;

public class ValidationUtil {

    private ValidationUtil() {}

    public static boolean isValidAmount(
            Double amount) {

        return amount != null
                && amount > 0;
    }
}