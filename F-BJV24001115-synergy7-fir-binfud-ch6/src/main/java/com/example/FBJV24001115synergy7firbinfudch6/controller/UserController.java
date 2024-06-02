package com.example.FBJV24001115synergy7firbinfudch6.controller;

import com.example.FBJV24001115synergy7firbinfudch6.model.accounts.Users;
import com.example.FBJV24001115synergy7firbinfudch6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable UUID id, @RequestBody Users user) {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}