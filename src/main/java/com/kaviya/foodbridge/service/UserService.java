package com.kaviya.foodbridge.service;

import com.kaviya.foodbridge.dto.RegisterRequest;
import com.kaviya.foodbridge.entity.User;

public interface UserService {

    User register(RegisterRequest request);

}