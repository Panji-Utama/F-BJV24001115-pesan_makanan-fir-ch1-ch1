package com.binarfud.FBJV24001115synergy7firbinfudch7.service;

import com.binarfud.FBJV24001115synergy7firbinfudch7.repository.UserRepository;
import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Override
//    public User registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        Set<Role> roles = new HashSet<>();
//        Role userRole = roleRepository.findByName(Role.ERole.ROLE_USER)
//                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//        roles.add(userRole);
//
//        user.setRoles(roles);
//
//        return userRepository.save(user);
//    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setDeleted(true);
        user.setDeletedDate(new Date());
        userRepository.save(user);
    }

    @Override
    public void softDeleteUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + userId));
        user.setDeleted(true);
        user.setDeletedDate(new Date());
        userRepository.save(user);
    }


    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public void createUserPostLogin(String email, String username) {
        if (!userRepository.existsByEmail(email)) {
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}