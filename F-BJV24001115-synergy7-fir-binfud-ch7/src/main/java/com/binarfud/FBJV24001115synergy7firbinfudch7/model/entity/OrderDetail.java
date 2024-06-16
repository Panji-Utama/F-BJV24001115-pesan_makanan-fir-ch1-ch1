package com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
@SQLDelete(sql = "UPDATE order_detail SET deleted_date = current_timestamp WHERE id = ?")
@SQLRestriction("deleted_date IS NULL")
public class OrderDetail extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer quantity;
    private BigDecimal totalPrice;

    @ManyToOne(targetEntity = Orders.class)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Orders order;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;
}
