package com.example.FBJV24001115synergy7firbinfudch5.repository;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    Users findByUsername(String username);
    Page<Users> findByUsernameContaining(String username, Pageable pageable);

    @Procedure(procedureName  = "procedure_create_user")
    void registerUser(@Param("c_username") String username, @Param("c_email") String email, @Param("c_pw")  String password);

    @Procedure(procedureName = "procedure_update_user")
    void updateUser(UUID new_id, String new_username, String new_email, String new_password);

    @Procedure(procedureName = "procedure_delete_user")
    void deleteUser(UUID user_id);
}