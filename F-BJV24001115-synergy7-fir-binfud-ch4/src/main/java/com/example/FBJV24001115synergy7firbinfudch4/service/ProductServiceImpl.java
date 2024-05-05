package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Product;
import com.example.FBJV24001115synergy7firbinfudch4.repository.MerchantRepository;
import com.example.FBJV24001115synergy7firbinfudch4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MerchantRepository merchantRepository;

//    @Override
//    public void addProduct(Double price, String productName, UUID merchantId) {
//        return productRepository.save(product);
//        productRepository.createProduct(price, productName, merchantId);
//    }

    @Override
    public Product addProduct(Double price, String productName, UUID merchantId) {
        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(() -> new RuntimeException("Merchant not found"));
        Product product = Product.builder()
                .productName(productName)
                .price(price)
                .merchant(merchant)
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
