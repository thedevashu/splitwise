package com.splitwise.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.app.Repositry.GroupRepo;
import com.splitwise.app.dto.Group;
import com.splitwise.app.dto.User;

@Service
public class GroupManager {
    @Autowired
    GroupRepo groupRepo;
    public void createGroup(Group group) {
        groupRepo.save(group);
    }
    public Group addUser(User user, Long groupId) {
        Group group = groupRepo.findById(groupId).get();
        group.getUsers().add(user);
        return groupRepo.save(group);
    }
}
