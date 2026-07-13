package com.kaviya.foodbridge.service.impl;

import com.kaviya.foodbridge.dto.DonationRequest;
import com.kaviya.foodbridge.entity.Donation;
import com.kaviya.foodbridge.enums.DonationStatus;
import com.kaviya.foodbridge.repository.DonationRepository;
import com.kaviya.foodbridge.service.DonationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public abstract class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Donation createDonation(DonationRequest request) {

        Donation donation = Donation.builder()
                .foodName(request.getFoodName())
                .quantity(request.getQuantity())
                .description(request.getDescription())
                .expiryTime(request.getExpiryTime())
                .pickupAddress(request.getPickupAddress())
                .status(DonationStatus.AVAILABLE)
                .createdAt(LocalDateTime.now())
                .build();

        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> getAvailableDonations() {
        return donationRepository.findByStatus(DonationStatus.AVAILABLE);
    }

    @Override
    public Donation getDonation(Long id){

        return donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

    }

    @Override
    public Donation updateDonation(Long id,
                                   DonationRequest request){

        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        donation.setFoodName(request.getFoodName());
        donation.setQuantity(request.getQuantity());
        donation.setDescription(request.getDescription());
        donation.setExpiryTime(request.getExpiryTime());
        donation.setPickupAddress(request.getPickupAddress());

        return donationRepository.save(donation);

    }

    @Override
    public void deleteDonation(Long id){

        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        donationRepository.delete(donation);

    }
}