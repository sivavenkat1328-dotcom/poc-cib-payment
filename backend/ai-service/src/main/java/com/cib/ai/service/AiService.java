package com.cib.ai.service;

import com.cib.ai.dto.AiRequest;
import com.cib.ai.dto.AiResponse;

import org.springframework.stereotype.Service;

@Service
public class AiService {

public AiResponse askQuestion(
        AiRequest request) {

    AiResponse response =
            new AiResponse();

    response.setAnswer(
            "AI Response : "
                    + request.getQuestion());

    if (request.getAmount() != null) {

        if (request.getAmount() >= 100000) {

            response.setRiskLevel(
                    "HIGH");

            response.setRiskScore(
                    90);

        } else if (request.getAmount() >= 50000) {

            response.setRiskLevel(
                    "MEDIUM");

            response.setRiskScore(
                    60);

        } else {

            response.setRiskLevel(
                    "LOW");

            response.setRiskScore(
                    20);
        }
    }

    return response;
}

public AiResponse fraudCheck(
        AiRequest request) {

    AiResponse response =
            new AiResponse();

    if (request.getAmount() >= 100000) {

        response.setRiskLevel(
                "HIGH");

        response.setRiskScore(
                90);

    } else if (request.getAmount() >= 50000) {

        response.setRiskLevel(
                "MEDIUM");

        response.setRiskScore(
                60);

    } else {

        response.setRiskLevel(
                "LOW");

        response.setRiskScore(
                20);
    }

    response.setAnswer(
            "Fraud Risk Analysis Completed");

    return response;
}

public AiResponse recommendation(
        String customerId) {

    AiResponse response =
            new AiResponse();

    response.setAnswer(
            "Upgrade to Premium Account");

    return response;
}


}
