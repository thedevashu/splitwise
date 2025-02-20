package com.splitwise.app.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitwise.app.dto.User;

public interface UserRepo extends JpaRepository<User,Long> {
    
}
