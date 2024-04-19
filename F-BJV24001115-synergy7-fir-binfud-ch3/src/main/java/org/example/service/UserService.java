package org.example.service;

import org.example.model.entity.Users;
import java.util.UUID;

public interface UserService {
    Users createUser(String username, String emailAddress, String password);
    Users getUserById(UUID userId);
}
