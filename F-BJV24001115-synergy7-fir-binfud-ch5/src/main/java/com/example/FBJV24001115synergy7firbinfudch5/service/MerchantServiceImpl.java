package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import com.example.FBJV24001115synergy7firbinfudch5.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public Merchant addMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant updateMerchantStatus(UUID merchantId, boolean isOpen) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found"));
        merchant.setOpen(isOpen);
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant getMerchantById(UUID id) {
        return merchantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found"));
    }

    @Override
    public List<Merchant> getOpenMerchants() {
        return merchantRepository.findByOpen(true);
    }

    @Override
    public void deleteMerchant(UUID id) {
        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found"));
        merchant.setDeletedDate(new Date());
        merchantRepository.save(merchant);
    }
}