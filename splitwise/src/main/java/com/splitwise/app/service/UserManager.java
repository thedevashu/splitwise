package com.splitwise.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.app.Repositry.UserRepo;
import com.splitwise.app.dto.User;

@Service
public class UserManager {
    @Autowired
    UserRepo userRepo;

    public void createUser(User user) {
        userRepo.save(user);
    }

    
}
