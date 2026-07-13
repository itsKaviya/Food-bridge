package com.kaviya.foodbridge.service;

import com.kaviya.foodbridge.dto.RegisterRequest;
import com.kaviya.foodbridge.entity.User;
import com.kaviya.foodbridge.dto.LoginRequest;
import com.kaviya.foodbridge.dto.LoginResponse;

public interface UserService {

    User register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}