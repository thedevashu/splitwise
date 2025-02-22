package com.splitwise.app.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitwise.app.dto.User;
import java.util.List;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Long> {
    public Optional<User>  findByUserEmail(String userEmail);
}
