package com.splitwise.app.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.splitwise.app.Repositry.UserRepo;
import com.splitwise.app.dto.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    
    private final UserRepo userRepo;
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        logger.info("Attempting to load user with email: {}", userEmail);
        Optional<User> user = userRepo.findByUserEmail(userEmail);
        User foundUser = user.orElseThrow(() -> new UsernameNotFoundException(userEmail + " not found"));
        logger.info("Found user: {}", foundUser);
        return foundUser;
    }
}
