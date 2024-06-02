package com.example.FBJV24001115synergy7firbinfudch6.repository;

import com.example.FBJV24001115synergy7firbinfudch6.model.accounts.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByUsername(String username);

    boolean existsByUsername(String username);
//    Page<Users> findByUsernameContaining(String username, Pageable pageable);
//
//    @Procedure(procedureName  = "procedure_create_user")
//    void registerUser(@Param("c_username") String username, @Param("c_email") String email, @Param("c_pw")  String password);
//
//    @Procedure(procedureName = "procedure_update_user")
//    void updateUser(UUID new_id, String new_username, String new_email, String new_password);
//
//    @Procedure(procedureName = "procedure_delete_user")
//    void deleteUser(UUID user_id);
}