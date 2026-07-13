package com.kaviya.foodbridge.service.impl;

import com.kaviya.foodbridge.dto.RegisterRequest;
import com.kaviya.foodbridge.entity.User;
import com.kaviya.foodbridge.repository.UserRepository;
import com.kaviya.foodbridge.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterRequest request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword()) // We'll encrypt later
                .phoneNumber(request.getPhoneNumber())
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .build();

        return userRepository.save(user);
    }
}