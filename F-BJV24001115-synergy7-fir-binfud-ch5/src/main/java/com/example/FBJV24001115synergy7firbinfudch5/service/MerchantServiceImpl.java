package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;
import com.example.FBJV24001115synergy7firbinfudch5.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<Merchant> getOpenMerchants() {
        return merchantRepository.findByOpen(true);
    }

    @Override
    public List<String> getProductsByMerchantName(String merchantName) {
//        return merchantRepository.findAllProductsByMerchantName(merchantName);
        List<Object[]> results = merchantRepository.findAllProductsByMerchantName(merchantName);
        if (results.isEmpty()) {
            return Collections.emptyList();
        }
        return results.stream()
                .map(result -> result[0] + " - " + result[1])
                .collect(Collectors.toList());
    }
}
