package com.kaviya.foodbridge.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonationRequest {

    @NotBlank
    private String foodName;

    @Min(1)
    private Integer quantity;

    @NotBlank
    private String description;

    @Future
    private LocalDateTime expiryTime;

    @NotBlank
    private String pickupAddress;
}