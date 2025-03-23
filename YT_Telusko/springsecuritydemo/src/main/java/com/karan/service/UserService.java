package com.karan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.karan.model.Users;
import com.karan.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository urepo;
    @Autowired
    private JWTService jwtService;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode password
        return urepo.save(user);
    }

    public String verify(Users user) {
        System.out.println("Authenticating: " + user.getUsername());
        Users dbUser = urepo.findByUsername(user.getUsername()); // Fetch user from DB
        if (dbUser == null || !passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            return "Login Failed: Invalid Username or Password"; // Ensure password matches
        }

        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            // return "Login Successful";
            return jwtService.generateToken(user.getUsername());
        } else {
            return "Login Failed";
        }
    }
}
