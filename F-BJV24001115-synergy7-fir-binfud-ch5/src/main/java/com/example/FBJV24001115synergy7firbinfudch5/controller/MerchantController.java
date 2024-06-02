package com.example.FBJV24001115synergy7firbinfudch5.controller;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.MerchantDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch5.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping
    public ResponseEntity<MerchantDTO> createMerchant(@RequestBody Merchant merchant) {
        return ResponseEntity.ok(merchantService.createMerchant(merchant));
    }

    @GetMapping
    public ResponseEntity<List<MerchantDTO>> getAllMerchants() {
        return ResponseEntity.ok(merchantService.getAllMerchants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MerchantDTO> getMerchantById(@PathVariable UUID id) {
        return ResponseEntity.ok(merchantService.getMerchantById(id));
    }
}
