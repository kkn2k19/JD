package com.karan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karan.model.Users;
import com.karan.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService uService;

    @Autowired
    private PasswordEncoder encoder; // Use Autowired Bean

    @PostMapping("/register")
    private Users register(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return uService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){

        return uService.verify(user);
    }

}
