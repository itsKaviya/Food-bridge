package com.kaviya.foodbridge.entity;

import com.kaviya.foodbridge.enums.DonationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;

    private Integer quantity;

    private String description;

    private LocalDateTime expiryTime;

    private String pickupAddress;

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor;
}