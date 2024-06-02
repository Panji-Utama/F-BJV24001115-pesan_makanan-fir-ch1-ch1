package com.example.FBJV24001115synergy7firbinfudch6.service;

import com.example.FBJV24001115synergy7firbinfudch6.model.accounts.Role;
import com.example.FBJV24001115synergy7firbinfudch6.model.accounts.Users;
import com.example.FBJV24001115synergy7firbinfudch6.repository.RoleRepository;
import com.example.FBJV24001115synergy7firbinfudch6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users registerUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(Role.ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        user.setRoles(roles);

        return userRepository.save(user);
    }

//    @Override
//    public Users registerUser(Users user) {
//        return userRepository.save(user);
//    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setDeleted(true);
        user.setDeletedDate(new Date());
        userRepository.save(user);
    }

    @Override
    public void softDeleteUser(UUID userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + userId));
        user.setDeleted(true);
        user.setDeletedDate(new Date());
        userRepository.save(user);
    }


    @Override
    public Users getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}