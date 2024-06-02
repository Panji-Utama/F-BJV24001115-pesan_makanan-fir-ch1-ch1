package com.example.FBJV24001115synergy7firbinfudch6.service;

import com.example.FBJV24001115synergy7firbinfudch6.model.accounts.Users;

import java.util.List;
import java.util.UUID;

public interface UserService {
    Users getUserById(UUID userId);

    void deleteUser(UUID userId);

    void softDeleteUser(UUID userId);

    Users registerUser(Users user);

    Users updateUser(Users user);

    List<Users> getAllUsers();
}

