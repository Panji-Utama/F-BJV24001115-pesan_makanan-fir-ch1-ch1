package com.binarfud.FBJV24001115synergy7firbinfudch7.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OtpServiceImpl {
    private final SecureRandom random = new SecureRandom();

    public String generateOtp() {
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
