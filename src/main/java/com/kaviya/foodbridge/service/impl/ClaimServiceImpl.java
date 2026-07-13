package com.kaviya.foodbridge.service.impl;

import com.kaviya.foodbridge.entity.Claim;
import com.kaviya.foodbridge.entity.Donation;
import com.kaviya.foodbridge.enums.ClaimStatus;
import com.kaviya.foodbridge.enums.DonationStatus;
import com.kaviya.foodbridge.repository.ClaimRepository;
import com.kaviya.foodbridge.repository.DonationRepository;
import com.kaviya.foodbridge.service.ClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final DonationRepository donationRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository,
                            DonationRepository donationRepository) {

        this.claimRepository = claimRepository;
        this.donationRepository = donationRepository;
    }

    @Override
    public Claim claimDonation(Long donationId) {

        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        if (donation.getStatus() != DonationStatus.AVAILABLE) {
            throw new RuntimeException("Donation has already been claimed");
        }

        donation.setStatus(DonationStatus.CLAIMED);
        donationRepository.save(donation);

        Claim claim = Claim.builder()
                .donation(donation)
                .status(ClaimStatus.PENDING)
                .claimedAt(LocalDateTime.now())
                .build();

        return claimRepository.save(claim);
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getClaim(Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }
}