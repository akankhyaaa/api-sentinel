package com.apisentinel.service;

import com.apisentinel.dto.LoginRequest;
import com.apisentinel.dto.LoginTokenResponse;
import com.apisentinel.dto.RegisterRequest;
import com.apisentinel.entity.User;
import com.apisentinel.repository.UserRepository;
import com.apisentinel.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private JwtUtil jwtUtil = new JwtUtil();

    public User registerUser(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        return userRepository.save(user);
    }

    public LoginTokenResponse loginUser(LoginRequest request) {

        Optional<User> userOptional =
                userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            return new LoginTokenResponse(
                    "User not found",
                    null
            );
        }

        User user = userOptional.get();

        if (passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            String token = jwtUtil.generateToken(user.getEmail());

            return new LoginTokenResponse(
                    "Login Successful",
                    token
            );
        }

        return new LoginTokenResponse(
                "Invalid Password",
                null
        );
    }
}
