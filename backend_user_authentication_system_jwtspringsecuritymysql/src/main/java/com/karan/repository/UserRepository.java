package com.karan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);   // user defined method to fing existing record for user through email
    // Optional used in place of *.orElse(null) -- it will prevent null pointer exceptions while searching
}
