package com.example.FBJV24001115synergy7firbinfudch6;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.account.ERole;
import com.example.FBJV24001115synergy7firbinfudch6.model.entity.account.Role;
import com.example.FBJV24001115synergy7firbinfudch6.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }

        if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }

        if (roleRepository.findByName(ERole.ROLE_MERCHANT).isEmpty()) {
            roleRepository.save(new Role(ERole.ROLE_MERCHANT));
        }
    }
}
