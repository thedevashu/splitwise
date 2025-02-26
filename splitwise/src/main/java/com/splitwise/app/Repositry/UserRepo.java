package com.splitwise.app.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.splitwise.app.dto.Users;
@Repository
public interface UserRepo extends JpaRepository<Users,Long> {

    public Optional<Users> findByUserName(String userName);
    
}
