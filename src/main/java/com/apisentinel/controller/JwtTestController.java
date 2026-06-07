package com.apisentinel.controller;

import com.apisentinel.security.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTestController {

    @GetMapping("/token")
    public String getToken() {

        JwtUtil jwtUtil = new JwtUtil();

        return jwtUtil.generateToken("userfour@gmail.com");
    }
}