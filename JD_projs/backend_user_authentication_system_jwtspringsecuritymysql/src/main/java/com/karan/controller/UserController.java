package com.karan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karan.dto.LoginRequest;
import com.karan.dto.RegisterRequest;
import com.karan.model.User;
import com.karan.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest r) {
        return new ResponseEntity<String>(uService.registerUser(r), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest l) {
        return new ResponseEntity<String>(uService.loginUser(l), HttpStatus.OK);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<User>> getUsers() {
        List<User> ulist = uService.getUsers();
        return new ResponseEntity<List<User>>(ulist, HttpStatus.OK);
    }
}
