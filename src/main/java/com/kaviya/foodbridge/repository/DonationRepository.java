package com.kaviya.foodbridge.repository;

import com.kaviya.foodbridge.entity.Donation;
import com.kaviya.foodbridge.enums.DonationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByStatus(DonationStatus status);

}