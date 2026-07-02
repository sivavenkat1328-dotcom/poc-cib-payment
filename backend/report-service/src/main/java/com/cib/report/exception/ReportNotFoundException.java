package com.cib.report.exception;

public class ReportNotFoundException
        extends RuntimeException {

    public ReportNotFoundException(
            String message) {

        super(message);
    }

    public ReportNotFoundException(
            String reportType,
            String referenceId) {

        super(reportType
                + " not found for reference : "
                + referenceId);
    }
}