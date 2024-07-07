package com.example.FBJV24001115synergy7firbinfudch6.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TokenController {

    @PostMapping("/api/save-token")
    public void saveToken(@RequestBody Map<String, String> body) {
        String token = body.get("token");
        // Save the token to your database
        System.out.println("Token received: " + token);
    }
}
