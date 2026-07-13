package com.kaviya.foodbridge.repository;

import com.kaviya.foodbridge.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}