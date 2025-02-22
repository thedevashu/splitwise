package com.splitwise.app.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.splitwise.app.Jwt.JwtUtil;
import com.splitwise.app.dto.LoginRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
 
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@Valid @RequestBody LoginRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors");
        }
        try {
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserEmail(), user.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = jwtUtil.generateToken(user.getUserEmail());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user: {}", user.getUserEmail(), e);
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser() {
        
  
        
        logger.info("User registered successfully");
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/test")
    public ResponseEntity<String> test() {
        logger.info("Registering user: {}");
        
        return ResponseEntity.ok("Successfully");
    }
}
