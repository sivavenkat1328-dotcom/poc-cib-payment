package com.cib.dashboard.dto;

public class FraudSummary {

    private Long approved;

    private Long rejected;

    private Long underReview;

    public Long getApproved() {
        return approved;
    }

    public void setApproved(Long approved) {
        this.approved = approved;
    }

    public Long getRejected() {
        return rejected;
    }

    public void setRejected(Long rejected) {
        this.rejected = rejected;
    }

    public Long getUnderReview() {
        return underReview;
    }

    public void setUnderReview(Long underReview) {
        this.underReview = underReview;
    }
}