package com.kaviya.foodbridge.service.impl;

import com.kaviya.foodbridge.entity.Claim;
import com.kaviya.foodbridge.entity.Donation;
import com.kaviya.foodbridge.entity.User;
import com.kaviya.foodbridge.enums.ClaimStatus;
import com.kaviya.foodbridge.enums.DonationStatus;
import com.kaviya.foodbridge.repository.ClaimRepository;
import com.kaviya.foodbridge.repository.DonationRepository;
import com.kaviya.foodbridge.repository.UserRepository;
import com.kaviya.foodbridge.service.ClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository,
                            DonationRepository donationRepository,
                            UserRepository userRepository) {

        this.claimRepository = claimRepository;
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
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

    @Override
    public Claim assignVolunteer(Long claimId, Long volunteerId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        User volunteer = userRepository.findById(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));

        claim.setVolunteer(volunteer);
        claim.setStatus(ClaimStatus.ACCEPTED);

        return claimRepository.save(claim);
    }

    @Override
    public Claim markPickedUp(Long claimId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        claim.setStatus(ClaimStatus.PICKED_UP);

        return claimRepository.save(claim);
    }

    @Override
    public Claim markDelivered(Long claimId) {

        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        claim.setStatus(ClaimStatus.DELIVERED);

        return claimRepository.save(claim);
    }
}