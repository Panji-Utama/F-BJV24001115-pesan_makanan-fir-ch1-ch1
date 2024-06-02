package com.example.FBJV24001115synergy7firbinfudch6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant")
@SQLDelete(sql = "UPDATE merchant SET deleted = true WHERE id = ?")
@SQLRestriction("deleted_date IS NULL")
public class Merchant extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String merchantName;
    private String merchantLocation;
    private Boolean open;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, targetEntity = Product.class)
    @JsonIgnore
    private List<Product> products;
}
