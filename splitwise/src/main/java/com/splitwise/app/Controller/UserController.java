package com.splitwise.app.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.splitwise.app.dto.User;
import com.splitwise.app.service.UserManager;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserManager userManager;
    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody User user) {
        //TODO: process POST request
        userManager.createUser(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> postMethodName(@PathVariable Long userId) {
        //TODO: process POST request
        User user = userManager.getUserById(userId).orElseThrow( () -> new RuntimeException("User not found"));
        return ResponseEntity.ok(user);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getMethodName() {
        List<User> users =userManager.getAllUsers();
        return ResponseEntity.ok().body(users);
    }
    
    
}
