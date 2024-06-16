package com.binarfud.FBJV24001115synergy7firbinfudch7.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/auth/oauth2/success")
    public ResponseEntity<String> oauth2Success() {
        return ResponseEntity.ok("Google OAuth Login Successful!");
    }
}
