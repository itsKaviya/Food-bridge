package com.kaviya.foodbridge.controller;

import com.kaviya.foodbridge.entity.Donation;
import com.kaviya.foodbridge.entity.User;
import com.kaviya.foodbridge.repository.DonationRepository;
import com.kaviya.foodbridge.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final DonationRepository donationRepository;

    public AdminController(UserRepository userRepository,
                           DonationRepository donationRepository) {

        this.userRepository = userRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/donations")
    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);

        return "User Deleted Successfully";
    }

}