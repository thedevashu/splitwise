package com.splitwise.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.splitwise.app.Repositry.UserRepo;
import com.splitwise.app.dto.Users;
import com.splitwise.app.dto.UserPrincipal;
@Service          
public class MyUserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username: " + username)    
        );
       
        return new UserPrincipal(user);
    }
    
    
}
