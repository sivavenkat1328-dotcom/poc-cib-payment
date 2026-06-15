package com.cib.fraud.service;

import com.cib.fraud.dto.FraudRequest;
import com.cib.fraud.dto.FraudResponse;
import com.cib.fraud.rules.AmountRule;
import com.cib.fraud.rules.LocationRule;
import com.cib.fraud.rules.TimeRule;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    private final AmountRule amountRule;
    private final LocationRule locationRule;
    private final TimeRule timeRule;

    public FraudDetectionService(
            AmountRule amountRule,
            LocationRule locationRule,
            TimeRule timeRule) {

        this.amountRule = amountRule;
        this.locationRule = locationRule;
        this.timeRule = timeRule;
    }

    public FraudResponse analyze(
            FraudRequest request) {

        int score =
                amountRule.evaluate(request.getAmount())
                + locationRule.evaluate(request.getLocation())
                + timeRule.evaluate(request.getTime());

        String level =
                score >= 70 ? "HIGH"
                : score >= 40 ? "MEDIUM"
                : "LOW";

        String recommendation =
                score >= 70
                ? "MANUAL_REVIEW"
                : "APPROVED";

        return new FraudResponse(
                score,
                level,
                recommendation);
    }
}