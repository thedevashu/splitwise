package com.splitwise.Jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private final String KEY = "my_key_ashu";

    public String generateToken(String email) {
     return Jwts.builder()
     .setSubject(email)
     .setIssuedAt(new Date())
     .setExpiration(new Date(System.currentTimeMillis()+86400000))
     .signWith(SignatureAlgorithm.HS256, KEY)
     .compact();   
    }
}
