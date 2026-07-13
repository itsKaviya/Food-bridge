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

    @GetMapping("/available")
    public List<Donation> getAvailableDonations() {
        return donationService.getAvailableDonations();
    }

    @GetMapping("/{id}")
    public Donation getDonation(@PathVariable Long id){

        return donationService.getDonation(id);

    }

    @PutMapping("/{id}")
    public Donation updateDonation(@PathVariable Long id,
                                   @RequestBody DonationRequest request){

        return donationService.updateDonation(id,request);

    }

    @DeleteMapping("/{id}")
    public String deleteDonation(@PathVariable Long id){

        donationService.deleteDonation(id);

        return "Donation Deleted Successfully";

    }
}