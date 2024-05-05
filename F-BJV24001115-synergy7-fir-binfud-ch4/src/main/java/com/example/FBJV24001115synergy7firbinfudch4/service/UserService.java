package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

//public interface UserService {
//    Users addUser(Users user);
//    Users updateUser(Users user);
//    void deleteUser(UUID userId);
//    Users getUserById(UUID userId);
//    Users findByUsername(String username);
//
//    Page<Users> findAllUsersByName(String name, int page, int size);
//}

public interface UserService {
    void registerUser(String username, String password, String email);
    Users findByUsername(String username);
    Users getUserById(UUID userId);
    void updateUser(UUID id, String new_username, String new_email, String new_password);
    void deleteUser(UUID userId);
    Page<Users> findAllUsersByName(String name, Pageable pageable);
}
