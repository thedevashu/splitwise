package com.splitwise.app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/test")
public class TestController {
    

    @GetMapping("/ping")
    public ResponseEntity postMethodName() {
        //TODO: proces POST reques
        return ResponseEntity.ok("pong");
    }

    
}
