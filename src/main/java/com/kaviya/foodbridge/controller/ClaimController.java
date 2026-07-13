package com.kaviya.foodbridge.controller;

import com.kaviya.foodbridge.entity.Claim;
import com.kaviya.foodbridge.service.ClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{donationId}")
    public Claim claimDonation(@PathVariable Long donationId) {

        return claimService.claimDonation(donationId);

    }

    @GetMapping
    public List<Claim> getAllClaims(){

        return claimService.getAllClaims();

    }

    @GetMapping("/{id}")
    public Claim getClaim(@PathVariable Long id){

        return claimService.getClaim(id);

    }
}