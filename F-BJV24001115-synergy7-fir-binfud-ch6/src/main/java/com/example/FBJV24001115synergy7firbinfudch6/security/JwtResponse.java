package com.example.FBJV24001115synergy7firbinfudch6.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    @Setter
    @Getter
    private String username;
    private List<String> roles;

    public JwtResponse(String accessToken, String username, List<String> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
    }
}