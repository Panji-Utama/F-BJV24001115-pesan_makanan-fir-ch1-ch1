package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.MerchantDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Merchant;

import java.util.List;
import java.util.UUID;

public interface MerchantService {
    MerchantDTO createMerchant(Merchant merchant);
    List<MerchantDTO> getAllMerchants();
    MerchantDTO getMerchantById(UUID id);
}
