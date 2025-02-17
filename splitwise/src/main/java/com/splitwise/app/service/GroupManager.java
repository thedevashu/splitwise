package com.splitwise.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.splitwise.app.Repositry.GroupRepo;
import com.splitwise.app.dto.Group;

public class GroupManager {
    @Autowired
    GroupRepo groupRepo;
    public void createGroup(Group group) {
        groupRepo.save(group);
    }
}
