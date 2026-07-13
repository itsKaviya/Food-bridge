package com.kaviya.foodbridge.controller;

import com.kaviya.foodbridge.dto.DonationRequest;
import com.kaviya.foodbridge.entity.Donation;
import com.kaviya.foodbridge.service.DonationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    public Donation createDonation(@Valid @RequestBody DonationRequest request) {
        return donationService.createDonation(request);
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }
}