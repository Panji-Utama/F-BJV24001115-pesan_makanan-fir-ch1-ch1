package com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
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
@SQLDelete(sql = "UPDATE orders SET deleted_date = current_timestamp WHERE id = ?")
@SQLRestriction("deleted_date IS NULL")
public class Orders extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date orderTime;
    private String destinationAddress;
    private Boolean completed;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = OrderDetail.class)
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
