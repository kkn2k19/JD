package com.karan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karan.model.UserPrincipal;
import com.karan.model.Users;
import com.karan.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository urepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = urepo.findByUsername(username);
        if (user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");
        }
    
        return new UserPrincipal(user);
    }

}
