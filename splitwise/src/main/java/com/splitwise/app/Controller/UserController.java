package com.splitwise.app.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.splitwise.app.dto.Users;
import com.splitwise.app.service.UserManager;

import jakarta.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController()
public class UserController {
    @Autowired
    UserManager userManager;
    @PostMapping("/create")
    public String createUser(@RequestBody Users user) {
        //TODO: process POST request
        userManager.createUser(user);
        return "ok";
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    @GetMapping("/test")
    public String createUser() {
        //TODO: process POST request
        // userManager.createUser(user);
        return "ok";
    }
    
}
