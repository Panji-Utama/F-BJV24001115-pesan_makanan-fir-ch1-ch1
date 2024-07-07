package com.example.FBJV24001115synergy7firbinfudch6.model.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateUserAndOrdersDTO {

    @NotNull
    private UUID userId;

    @NotBlank
    @Email
    private String newEmail;

    @NotBlank
    private String newAddress;
}