package com.example.FBJV24001115synergy7firbinfudch4.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date orderTime;
    private String destinationAddress;
    private Boolean completed;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, targetEntity = OrderDetail.class)
    private List<OrderDetail> orderDetails;
}
