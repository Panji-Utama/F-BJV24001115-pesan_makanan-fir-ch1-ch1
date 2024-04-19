package org.example.service;

import org.example.model.entity.Merchant;
import org.example.service.MerchantService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MerchantServiceImpl implements MerchantService {
    private final Map<UUID, Merchant> merchants = new HashMap<>();

    @Override
    public Merchant createMerchant(String name, String location, boolean isOpen) {
        UUID merchantId = UUID.randomUUID();
        Merchant merchant = new Merchant(merchantId, name, location, isOpen);
        merchants.put(merchantId, merchant);
        return merchant;
    }

    @Override
    public Merchant getMerchantById(UUID merchantId) {
        return merchants.get(merchantId);
    }
}
