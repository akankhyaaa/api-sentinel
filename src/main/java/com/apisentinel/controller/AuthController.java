package com.apisentinel.controller;

import com.apisentinel.dto.LoginRequest;
import com.apisentinel.dto.LoginTokenResponse;
import com.apisentinel.dto.RegisterRequest;
import com.apisentinel.entity.User;
import com.apisentinel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginTokenResponse login(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
}