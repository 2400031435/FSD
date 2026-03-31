package com.artvista.controller;

import com.artvista.model.User;
import com.artvista.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User registered = userService.register(user);
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Registration successful",
                    "user", Map.of(
                            "id", registered.getId(),
                            "name", registered.getName(),
                            "email", registered.getEmail(),
                            "role", registered.getRole())));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            User user = userService.login(credentials.get("email"), credentials.get("password"));
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Login successful",
                    "user", Map.of(
                            "id", user.getId(),
                            "name", user.getName(),
                            "email", user.getEmail(),
                            "role", user.getRole())));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()));
        }
    }
}
