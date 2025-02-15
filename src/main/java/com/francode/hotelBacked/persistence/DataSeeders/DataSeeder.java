package com.francode.hotelBacked.persistence.DataSeeders;

import com.francode.hotelBacked.domain.entity.ERole;
import com.francode.hotelBacked.domain.entity.Role;
import com.francode.hotelBacked.domain.entity.UserApp;
import com.francode.hotelBacked.persistence.repository.JpaUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(JpaUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {

            Role adminRole = new Role();
            adminRole.setName(ERole.ROLE_ADMIN);

            Set<Role> roles = Collections.singleton(adminRole);

            UserApp adminUser = new UserApp();
            adminUser.setEmail("admin@gmail.com");
            adminUser.setPassword(passwordEncoder.encode("123456"));
            adminUser.setRoles(roles);

            userRepository.save(adminUser);
            System.out.println("Usuario admin creado exitosamente.");
        } else {
            System.out.println("El usuario admin ya existe.");
        }
    }
}
