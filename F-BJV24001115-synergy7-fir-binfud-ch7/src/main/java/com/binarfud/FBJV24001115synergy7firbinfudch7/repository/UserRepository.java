package com.binarfud.FBJV24001115synergy7firbinfudch7.repository;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String emailAddress);
//    Page<User> findByUsernameContaining(String username, Pageable pageable);
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