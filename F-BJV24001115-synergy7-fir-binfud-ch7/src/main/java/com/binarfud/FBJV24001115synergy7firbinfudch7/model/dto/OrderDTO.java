package com.binarfud.FBJV24001115synergy7firbinfudch7.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String destinationAddress;
    private Boolean completed;
    private UserDTO user;
    private List<OrderDetailDTO> orderDetails;
}
