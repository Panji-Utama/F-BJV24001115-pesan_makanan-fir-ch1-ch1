package com.example.FBJV24001115synergy7firbinfudch6.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    private Integer quantity;
    private BigDecimal totalPrice;
    private ProductDTO product;
}