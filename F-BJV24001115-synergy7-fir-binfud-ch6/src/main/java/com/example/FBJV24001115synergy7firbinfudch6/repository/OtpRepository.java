package com.example.FBJV24001115synergy7firbinfudch6.repository;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> findByEmail(String email);
}