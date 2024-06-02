package com.example.FBJV24001115synergy7firbinfudch6.repository;

import com.example.FBJV24001115synergy7firbinfudch6.model.accounts.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(Role.ERole name);
}
