package com.cib.audit.service;

import com.cib.audit.dto.AuditRequest;
import com.cib.audit.dto.AuditResponse;
import com.cib.audit.entity.AuditLog;
import com.cib.audit.exception.AuditNotFoundException;
import com.cib.audit.repository.AuditRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AuditRepository repository;

    public AuditResponse createAudit(
            AuditRequest request) {

        AuditLog log =
                new AuditLog();

        log.setServiceName(
                request.getServiceName());

        log.setAction(
                request.getAction());

        log.setPerformedBy(
                request.getPerformedBy());

        log.setReferenceId(
                request.getReferenceId());

        log.setStatus(
                request.getStatus());

        log.setActionTime(
                LocalDateTime.now());

        AuditLog saved =
                repository.save(log);

        AuditResponse response =
                new AuditResponse();

        response.setAuditId(
                saved.getId());

        response.setMessage(
                "Audit Log Created Successfully");

        return response;
    }

    public List<AuditLog> getAllAudits() {

        return repository.findAll();
    }

    public List<AuditLog> getByReference(
            String referenceId) {

        List<AuditLog> logs =
                repository.findByReferenceId(
                        referenceId);

        if (logs.isEmpty()) {

            throw new AuditNotFoundException(
                    "Audit Logs Not Found");
        }

        return logs;
    }
}