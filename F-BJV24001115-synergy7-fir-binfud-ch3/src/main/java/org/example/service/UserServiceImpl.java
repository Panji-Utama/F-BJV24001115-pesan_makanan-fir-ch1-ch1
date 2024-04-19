package org.example.service;

import org.example.model.entity.Users;
import org.example.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final Map<UUID, Users> users = new HashMap<>();

    @Override
    public Users createUser(String username, String emailAddress, String password) {
        UUID userId = UUID.randomUUID();
        Users user = new Users(userId, username, emailAddress, password);
        users.put(userId, user);
        return user;
    }

    @Override
    public Users getUserById(UUID userId) {
        return users.get(userId);
    }
}
