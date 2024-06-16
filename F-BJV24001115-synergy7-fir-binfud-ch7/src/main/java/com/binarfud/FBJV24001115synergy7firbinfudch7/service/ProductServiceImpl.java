package com.binarfud.FBJV24001115synergy7firbinfudch7.service;

import com.binarfud.FBJV24001115synergy7firbinfudch7.repository.MerchantRepository;
import com.binarfud.FBJV24001115synergy7firbinfudch7.repository.ProductRepository;
import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.Merchant;
import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MerchantRepository merchantRepository;

//    @Override
//    public Product addProduct(Product product) {
//        return productRepository.save(product);
//    }

    @Override
    public Product addProduct(Product product) {
        UUID merchantId = product.getMerchant().getId();
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found"));
        product.setMerchant(merchant);

        if (product.getPrice() == null) {
            throw new IllegalArgumentException("Product price cannot be null");
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setDeletedDate(new Date());
        productRepository.save(product);
    }

    @Override
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
