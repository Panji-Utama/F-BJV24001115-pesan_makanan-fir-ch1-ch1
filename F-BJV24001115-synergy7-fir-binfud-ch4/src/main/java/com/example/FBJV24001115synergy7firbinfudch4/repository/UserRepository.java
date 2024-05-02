package com.example.FBJV24001115synergy7firbinfudch4.repository;

import com.example.FBJV24001115synergy7firbinfudch4.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {

}
