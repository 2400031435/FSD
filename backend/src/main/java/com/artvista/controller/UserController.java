package com.artvista.controller;

import com.artvista.model.User;
import com.artvista.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Map<String, Object>> getAllUsers() {
        return userService.getAllUsers().stream().map(u -> Map.<String, Object>of(
                "id", u.getId(),
                "name", u.getName(),
                "email", u.getEmail(),
                "role", u.getRole())).toList();
    }

    @PutMapping("/{id}/role")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @RequestBody Map<String, String> body) {
        try {
            User updated = userService.updateRole(id, body.get("role"));
            return ResponseEntity.ok(Map.of("success", true, "message", "Role updated",
                    "user", Map.of("id", updated.getId(), "name", updated.getName(),
                            "email", updated.getEmail(), "role", updated.getRole())));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        }
    }
}
