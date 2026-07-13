package com.kaviya.foodbridge.repository;

import com.kaviya.foodbridge.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}