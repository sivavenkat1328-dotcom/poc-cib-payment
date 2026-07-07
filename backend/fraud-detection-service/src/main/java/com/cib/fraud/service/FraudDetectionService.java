package com.cib.fraud.service;

import com.cib.fraud.dto.FraudRequest;
import com.cib.fraud.dto.FraudResponse;
import com.cib.fraud.entity.FraudDetection;
import com.cib.fraud.repository.FraudDetectionRepository;
import com.cib.fraud.rules.AmountRule;
import com.cib.fraud.rules.LocationRule;
import com.cib.fraud.rules.TimeRule;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionService {

    private final AmountRule amountRule;
    private final LocationRule locationRule;
    private final TimeRule timeRule;
    private final FraudDetectionRepository repository;

    public FraudDetectionService(
            AmountRule amountRule,
            LocationRule locationRule,
            TimeRule timeRule,
            FraudDetectionRepository repository) {

        this.amountRule = amountRule;
        this.locationRule = locationRule;
        this.timeRule = timeRule;
        this.repository = repository;
    }

    // Check Fraud
    public FraudResponse analyze(FraudRequest request) {

        int score =
                amountRule.evaluate(request.getAmount())
                        + locationRule.evaluate(request.getLocation())
                        + timeRule.evaluate(request.getTime());

        String level =
                score >= 70 ? "HIGH"
                        : score >= 40 ? "MEDIUM"
                        : "LOW";

        String recommendation =
                score >= 70 ? "MANUAL_REVIEW"
                        : "APPROVED";

        FraudDetection fraud = new FraudDetection();

        fraud.setTransactionId("TXN-" + System.currentTimeMillis());
        fraud.setFromAccount(request.getFromAccount());
        fraud.setToAccount(request.getToAccount());
        fraud.setAmount(request.getAmount());
        fraud.setTransactionType(request.getTransactionType());
        fraud.setLocation(request.getLocation());
        fraud.setRiskScore(score);
        fraud.setRiskLevel(level);
        fraud.setRecommendation(recommendation);
        fraud.setStatus("COMPLETED");
        fraud.setTransactionTime(LocalDateTime.now());

        repository.save(fraud);

        return new FraudResponse(
                score,
                level,
                recommendation
        );
    }

    // Get All Fraud History
    public List<FraudDetection> getFraudHistory() {
        return repository.findAll();
    }

    // Get Fraud By Id
    public FraudDetection getFraudById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Fraud record not found"));
    }

    // Delete Fraud Record
    public String deleteFraud(Long id) {
        repository.deleteById(id);
        return "Fraud record deleted successfully";
    }
}