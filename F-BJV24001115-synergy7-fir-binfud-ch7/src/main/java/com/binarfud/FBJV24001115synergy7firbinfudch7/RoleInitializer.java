package com.binarfud.FBJV24001115synergy7firbinfudch7;

import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.ERole;
import com.binarfud.FBJV24001115synergy7firbinfudch7.model.entity.account.Role;
import com.binarfud.FBJV24001115synergy7firbinfudch7.repository.RoleRepository;
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
