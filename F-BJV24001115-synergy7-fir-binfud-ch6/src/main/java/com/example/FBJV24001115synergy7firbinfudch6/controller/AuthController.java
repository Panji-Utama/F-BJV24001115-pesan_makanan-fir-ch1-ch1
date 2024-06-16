package com.example.FBJV24001115synergy7firbinfudch6.controller;

import com.example.FBJV24001115synergy7firbinfudch6.model.dto.EmailDTO;
import com.example.FBJV24001115synergy7firbinfudch6.model.dto.OtpVerificationDTO;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Otp;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.account.ERole;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.account.Role;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.account.User;
import com.example.FBJV24001115synergy7firbinfudch6.model.jwt.request.LoginDTO;
import com.example.FBJV24001115synergy7firbinfudch6.model.jwt.request.RegisterDTO;
import com.example.FBJV24001115synergy7firbinfudch6.model.jwt.response.JwtResponse;
import com.example.FBJV24001115synergy7firbinfudch6.model.jwt.response.MessageResponse;
import com.example.FBJV24001115synergy7firbinfudch6.repository.OtpRepository;
import com.example.FBJV24001115synergy7firbinfudch6.repository.RoleRepository;
import com.example.FBJV24001115synergy7firbinfudch6.repository.UserRepository;
import com.example.FBJV24001115synergy7firbinfudch6.security.jwt.JwtUtils;
import com.example.FBJV24001115synergy7firbinfudch6.security.services.UserDetailsImpl;
import com.example.FBJV24001115synergy7firbinfudch6.service.EmailServiceImpl;
import com.example.FBJV24001115synergy7firbinfudch6.service.OtpServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    OtpServiceImpl otpService;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    OtpRepository otpRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        String otp = otpService.generateOtp();
        emailService.sendOtp(signUpRequest.getEmail(), otp);

        otpRepository.save(new Otp(signUpRequest.getEmail(), otp));

        return ResponseEntity.ok(new MessageResponse("OTP sent to email. Please verify to complete registration."));
    }

    @PostMapping("/signup/verify")
    public ResponseEntity<?> verifyOtp(@Valid @RequestBody OtpVerificationDTO otpVerificationDTO) {
        Otp otpEntity = otpRepository.findByEmail(otpVerificationDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Error: OTP not found."));

        if (!otpEntity.getOtp().equals(otpVerificationDTO.getOtp())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid OTP."));
        }

        User user = new User(otpVerificationDTO.getUsername(), otpVerificationDTO.getEmail(), encoder.encode(otpVerificationDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        otpVerificationDTO.getRole().forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                    break;
                case "merchant":
                    Role merchantRole = roleRepository.findByName(ERole.ROLE_MERCHANT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(merchantRole);
                    break;
                default:
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);

        otpRepository.delete(otpEntity);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@Valid @RequestBody EmailDTO emailDTO) {
        if (!userRepository.existsByEmail(emailDTO.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email not found."));
        }

        String otp = otpService.generateOtp();
        emailService.sendOtp(emailDTO.getEmail(), otp);

        otpRepository.save(new Otp(emailDTO.getEmail(), otp));

        return ResponseEntity.ok(new MessageResponse("OTP sent to email. Please verify to reset password."));
    }

    @PostMapping("/forget-password/verify")
    public ResponseEntity<?> verifyOtpForPasswordReset(@Valid @RequestBody OtpVerificationDTO otpVerificationDTO) {
        Otp otpEntity = otpRepository.findByEmail(otpVerificationDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Error: OTP not found."));

        if (!otpEntity.getOtp().equals(otpVerificationDTO.getOtp())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid OTP."));
        }

        User user = userRepository.findByEmail(otpVerificationDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
        user.setPassword(encoder.encode(otpVerificationDTO.getPassword()));
        userRepository.save(user);

        otpRepository.delete(otpEntity);

        return ResponseEntity.ok(new MessageResponse("Password reset successfully!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            jwtUtils.invalidateJwtToken(jwt);
        }
        return ResponseEntity.ok(new MessageResponse("User logged out successfully!"));
    }

    @GetMapping("/oauth2/success")
    public ResponseEntity<String> oauth2Success() {
        return ResponseEntity.ok("Google OAuth Login Successful!");
    }
}
