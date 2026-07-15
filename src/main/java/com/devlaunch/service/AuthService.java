package com.devlaunch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devlaunch.dto.LoginRequest;
import com.devlaunch.dto.LoginResponse;
import com.devlaunch.dto.RegisterRequest;
import com.devlaunch.entity.User;
import com.devlaunch.exception.EmailAlreadyExistsException;
import com.devlaunch.repository.UserRepository;
import com.devlaunch.security.JwtUtil;
import com.devlaunch.dto.RegisterResponse;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists!");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        RegisterResponse response = new RegisterResponse();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setMessage("Registration Successful");

        return response;
    }
    
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new RuntimeException("Invalid Email");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        LoginResponse response = new LoginResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setMessage("Login Successful");
        String token = jwtUtil.generateToken(user.getEmail());

        response.setToken(token);

        return response;
    }
    
    @Autowired
    private JwtUtil jwtUtil;

}