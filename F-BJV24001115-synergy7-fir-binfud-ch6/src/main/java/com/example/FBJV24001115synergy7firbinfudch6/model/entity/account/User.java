package com.example.FBJV24001115synergy7firbinfudch6.model.entity.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.BaseModel;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Orders;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String password;

    public User(String username, String emailAddress, String password) {
        this.username = username;
        this.email = emailAddress;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, targetEntity = Orders.class)
    @JsonIgnore
    private List<Orders> orders;
}