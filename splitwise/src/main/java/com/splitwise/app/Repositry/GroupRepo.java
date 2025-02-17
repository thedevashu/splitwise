package com.splitwise.app.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitwise.app.dto.Group;

public interface GroupRepo extends JpaRepository<Group,Long> {
    
    
}
