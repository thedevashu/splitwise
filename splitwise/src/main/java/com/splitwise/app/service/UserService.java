package com.splitwise.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.splitwise.app.Repositry.UserRepo;
import com.splitwise.app.dto.User;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private  UserRepo userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
       
       Optional<User> user =userRepository.findByUserEmail(userEmail);
       
        return user.orElseThrow(()->
        new UsernameNotFoundException(userEmail + " not found")
        );
    }

    public User registerUser(User user1) {
        User user = new User();
user.setUserEmail("test@example.com");
user.setPassword(passwordEncoder.encode("password123"));
userRepository.save(user);

        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
