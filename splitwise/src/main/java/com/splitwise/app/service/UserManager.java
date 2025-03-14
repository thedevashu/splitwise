package com.splitwise.app.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserById(Long userId) {
        // TODO Auto-generated method stub
        return userRepo.findById(userId);
        
    }

    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userRepo.findAll();
    }
}
