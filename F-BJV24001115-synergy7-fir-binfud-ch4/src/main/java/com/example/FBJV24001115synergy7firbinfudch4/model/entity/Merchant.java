package com.example.FBJV24001115synergy7firbinfudch4.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant")
public class Merchant extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String merchant_name;
    private String merchant_location;
    private Boolean open;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, targetEntity = Product.class)
    private List<Product> products;
}
