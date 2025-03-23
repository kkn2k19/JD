package com.karan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karan.model.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

    
}
