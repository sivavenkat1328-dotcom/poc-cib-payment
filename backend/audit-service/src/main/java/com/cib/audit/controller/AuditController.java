package com.cib.audit.controller;

import com.cib.audit.dto.AuditRequest;
import com.cib.audit.dto.AuditResponse;
import com.cib.audit.entity.AuditLog;
import com.cib.audit.service.AuditService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    @Autowired
    private AuditService service;

    @PostMapping
    public AuditResponse createAudit(
            @RequestBody AuditRequest request) {

        return service.createAudit(
                request);
    }

    @GetMapping
    public List<AuditLog> getAllAudits() {

        return service.getAllAudits();
    }

    @GetMapping("/reference/{referenceId}")
    public List<AuditLog> getByReference(
            @PathVariable String referenceId) {

        return service.getByReference(
                referenceId);
    }
}