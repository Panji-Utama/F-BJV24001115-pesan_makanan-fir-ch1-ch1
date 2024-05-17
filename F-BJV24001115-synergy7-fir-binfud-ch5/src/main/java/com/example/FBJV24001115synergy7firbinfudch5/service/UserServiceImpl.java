package com.example.FBJV24001115synergy7firbinfudch5.service;

import com.example.FBJV24001115synergy7firbinfudch5.model.dto.UsersDTO;
import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Users;
import com.example.FBJV24001115synergy7firbinfudch5.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsersDTO createUser(Users user) {
        Users savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UsersDTO.class);
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UsersDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDTO getUserById(UUID id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return modelMapper.map(user, UsersDTO.class);
    }
}
