package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.ProductDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDTO addProduct(Product product);
    ProductDTO updateProduct(Product product);
    void deleteProduct(UUID productId);
    ProductDTO getProductById(UUID productId);
    List<ProductDTO> getAllProducts();
}
