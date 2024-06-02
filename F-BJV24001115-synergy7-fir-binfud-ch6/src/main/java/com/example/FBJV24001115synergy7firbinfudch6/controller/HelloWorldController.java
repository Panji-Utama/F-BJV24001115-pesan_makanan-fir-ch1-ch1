package com.example.FBJV24001115synergy7firbinfudch6.controller;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Merchant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


public class HelloWorldController {
    @GetMapping("/")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World!");
    }
}
