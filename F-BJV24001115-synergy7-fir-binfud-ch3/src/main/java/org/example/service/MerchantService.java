package org.example.service;

import org.example.model.entity.Merchant;
import java.util.UUID;

public interface MerchantService {
    Merchant createMerchant(String name, String location, boolean isOpen);
    Merchant getMerchantById(UUID merchantId);
}
