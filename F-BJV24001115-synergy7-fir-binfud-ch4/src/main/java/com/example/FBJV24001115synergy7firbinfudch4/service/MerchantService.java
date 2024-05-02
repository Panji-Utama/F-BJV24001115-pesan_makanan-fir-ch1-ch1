package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Merchant;

import java.util.List;
import java.util.UUID;

public interface MerchantService {
    Merchant addMerchant(Merchant merchant);
    Merchant updateMerchantStatus(UUID merchantId, boolean isOpen);
    List<Merchant> getOpenMerchants();
}
