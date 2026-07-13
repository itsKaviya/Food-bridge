package com.kaviya.foodbridge.service;

import com.kaviya.foodbridge.dto.DonationRequest;
import com.kaviya.foodbridge.entity.Donation;

import java.util.List;

public interface DonationService {

    Donation createDonation(DonationRequest request);

    List<Donation> getAllDonations();

}