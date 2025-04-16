package com.ingestiontool.backend;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Backend - LoginController.java
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Your login logic (e.g., check credentials and return JWT or session)
        if ("admin".equals(username) && "password".equals(password)) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body("Invalid Credentials");
        }
    }
}

