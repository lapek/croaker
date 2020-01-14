package com.raven.croaker;

import com.raven.croaker.model.Role;
import com.raven.croaker.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

import static com.raven.croaker.model.Roles.ADMIN;
import static com.raven.croaker.model.Roles.USER;


@SpringBootApplication
public class CroakerApp {

    private static final Logger log = LoggerFactory.getLogger(CroakerApp.class);

    public static void main(String[] args) {
        SpringApplication.run(CroakerApp.class, args);

        log.info("\n----------------------------------------------------------\n\t"
                + "Application is running!" +
                "\n----------------------------------------------------------");
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {
        return args -> {
            Optional<Role> adminRole = roleRepository.findByRoleName(ADMIN.getName());
            if (!adminRole.isPresent()) {
                Role newAdminRole = new Role();
                newAdminRole.setRoleName(ADMIN.getName());
                roleRepository.save(newAdminRole);
            }

            Optional<Role> userRole = roleRepository.findByRoleName(USER.getName());
            if (!userRole.isPresent()) {
                Role newUserRole = new Role();
                newUserRole.setRoleName(USER.getName());
                roleRepository.save(newUserRole);
            }
        };
    }
}
