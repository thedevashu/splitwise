package com.splitwise.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.app.dto.Group;
import com.splitwise.app.dto.User;
import com.splitwise.app.service.GroupManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController()
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupManager groupManager;
    
    @PostMapping("/create")
    public ResponseEntity createGroup(@RequestBody Group group) {
        groupManager.createGroup(group);
        return ResponseEntity.ok(group);
    }
    @PostMapping("addUser/{id}")
    public Group putMethodName(@PathVariable("id") Long groupId, @RequestBody User user) {
        //TODO: process PUT request
        
        return groupManager.addUser(user, groupId);
    }
    
}
