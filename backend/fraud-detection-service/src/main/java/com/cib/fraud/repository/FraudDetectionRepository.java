package com.cib.fraud.repository;

import com.cib.fraud.entity.FraudDetection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudDetectionRepository extends JpaRepository<FraudDetection, Long> {
}