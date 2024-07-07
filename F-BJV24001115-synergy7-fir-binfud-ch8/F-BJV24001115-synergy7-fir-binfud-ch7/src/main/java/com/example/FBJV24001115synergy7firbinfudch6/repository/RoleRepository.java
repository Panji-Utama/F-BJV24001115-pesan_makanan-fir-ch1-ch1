package com.example.FBJV24001115synergy7firbinfudch6.repository;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.account.ERole;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

