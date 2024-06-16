package com.binarfud.FBJV24001115synergy7firbinfudch7.service;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User getUserById(UUID userId);

    void deleteUser(UUID userId);

    void createUserPostLogin(String email, String username);

    void softDeleteUser(UUID userId);

    User registerUser(User user);

    User updateUser(User user);

    List<User> getAllUsers();
}

