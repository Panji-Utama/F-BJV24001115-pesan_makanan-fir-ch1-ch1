package com.example.FBJV24001115synergy7firbinfudch6.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String emailAddress;
    private String password;
    private List<OrderDTO> orders;
}
