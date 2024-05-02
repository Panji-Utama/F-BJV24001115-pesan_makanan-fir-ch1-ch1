package com.example.FBJV24001115synergy7firbinfudch4.service;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Users;

import java.util.UUID;

public interface UserService {
    Users addUser(Users user);
    Users updateUser(Users user);
    void deleteUser(UUID userId);
}
