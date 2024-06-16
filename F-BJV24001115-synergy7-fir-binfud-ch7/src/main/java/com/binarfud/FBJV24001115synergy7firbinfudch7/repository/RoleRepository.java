package com.binarfud.FBJV24001115synergy7firbinfudch7.repository;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.ERole;
import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

