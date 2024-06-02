package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.MerchantDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch5.repository.MerchantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MerchantDTO createMerchant(Merchant merchant) {
        Merchant savedMerchant = merchantRepository.save(merchant);
        return modelMapper.map(savedMerchant, MerchantDTO.class);
    }

    @Override
    public List<MerchantDTO> getAllMerchants() {
        return merchantRepository.findAll().stream()
                .map(merchant -> modelMapper.map(merchant, MerchantDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MerchantDTO getMerchantById(UUID id) {
        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found"));
        return modelMapper.map(merchant, MerchantDTO.class);
    }
}
