package com.binarfud.FBJV24001115synergy7firbinfudch7.repository;
import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> findByEmail(String email);
}