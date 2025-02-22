package com.splitwise.app.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.splitwise.app.dto.User;
import com.splitwise.app.service.UserManager;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController()
public class UserController {
    @Autowired
    UserManager userManager;
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        //TODO: process POST request
        userManager.createUser(user);
        return "ok";
    }

    


    
}
