package com.example.FBJV24001115synergy7firbinfudch4.repository;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    Users findByUsername(String username);
    Page<Users> findByUsernameContaining(String username, Pageable pageable);
    @Procedure(name = "register_user")
    void registerUser(String username, String email, String password);
}