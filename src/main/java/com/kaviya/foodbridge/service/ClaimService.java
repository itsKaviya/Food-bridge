package com.kaviya.foodbridge.service;

import com.kaviya.foodbridge.entity.Claim;

import java.util.List;

public interface ClaimService {

    Claim claimDonation(Long donationId);

    List<Claim> getAllClaims();

    Claim getClaim(Long id);

}