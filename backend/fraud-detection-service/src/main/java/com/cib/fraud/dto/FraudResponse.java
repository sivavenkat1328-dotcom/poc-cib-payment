package com.cib.fraud.dto;

public class FraudResponse {

    private int riskScore;
    private String riskLevel;
    private String recommendation;

    public FraudResponse() {
    }

    public FraudResponse(
            int riskScore,
            String riskLevel,
            String recommendation) {

        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.recommendation = recommendation;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public String getRecommendation() {
        return recommendation;
    }
}