package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Users;

import java.util.List;
import java.util.UUID;

public interface UserService {
    Users getUserById(UUID userId);

    void deleteUser(UUID userId);

    Users registerUser(Users user);

    Users updateUser(Users user);

    List<Users> getAllUsers();
}

