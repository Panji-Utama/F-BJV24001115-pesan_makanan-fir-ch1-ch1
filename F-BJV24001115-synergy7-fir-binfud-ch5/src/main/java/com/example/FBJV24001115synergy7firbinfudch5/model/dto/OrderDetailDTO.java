package com.example.FBJV24001115synergy7firbinfudch5.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {
    private Integer quantity;
    private Double totalPrice;
    private ProductDTO product;
}
