package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.UsersDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Users;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UsersDTO createUser(Users user);
    List<UsersDTO> getAllUsers();
    UsersDTO getUserById(UUID id);
}
