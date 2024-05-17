package com.example.FBJV24001115synergy7firbinfudch5.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrdersDTO {
    private Date orderTime;
    private String destinationAddress;
    private Boolean completed;
    private List<OrderDetailDTO> orderDetails;
}
