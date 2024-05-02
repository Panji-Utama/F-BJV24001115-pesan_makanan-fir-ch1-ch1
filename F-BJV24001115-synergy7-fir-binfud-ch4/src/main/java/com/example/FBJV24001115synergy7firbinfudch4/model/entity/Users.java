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
@Table(name = "users")
public class Users extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;
    private String emailAddress;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = Order.class)
    private List<Order> orders;
}
