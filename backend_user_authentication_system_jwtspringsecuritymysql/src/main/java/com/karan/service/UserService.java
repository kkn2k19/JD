package com.karan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.karan.dto.LoginRequest;
import com.karan.dto.RegisterRequest;
import com.karan.model.User;
import com.karan.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository urepo;

    private BCryptPasswordEncoder bpe = new BCryptPasswordEncoder(12); // passing the strength value which means
                                                                       // 2^strength times hashing

    public List<User> getUsers() {
        return urepo.findAll();
    }

    public String registerUser(RegisterRequest r) {
        Optional<User> existingUser = urepo.findByEmail(r.getEmail()); // first extracts email from r then find that in
                                                                       // user table

        if (existingUser.isPresent()) { // if a value found then true otherwise false
            return "Email already Exists!";
        }

        User u = new User();
        u.setUname(r.getUname());
        u.setEmail(r.getEmail());
        u.setPass(bpe.encode(r.getPass()));

        urepo.save(u);
        return "User registered successfully!";
    }

    public String loginUser(LoginRequest l) {
        Optional<User> u = urepo.findByEmail(l.getEmail());

        if (u.isPresent() && bpe.matches(l.getPass(), u.get().getPass())) { // Compare raw password with hashed password
            return "Login Successful!";
        } else {
            return "Invalid email or password!";
        }
    }
}
