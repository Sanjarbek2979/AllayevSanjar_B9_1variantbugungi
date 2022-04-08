package com.example.allayevsanjar_b9_1variant.component;

import com.example.allayevsanjar_b9_1variant.entity.User;
import com.example.allayevsanjar_b9_1variant.entity.enums.RoleEnum;
import com.example.allayevsanjar_b9_1variant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Sanjarbek Allayev, пт 9:18. 08.04.2022
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    final Generator generator;
    final UserRepository userRepository;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Value("${spring.sql.init.mode}")
    private String mode;


    @Override
    public void run(String... args) throws Exception {
        if (ddl.equals("create") && mode.equals("always")){
            User user = new User("ketmon", "user", generator.passwordEncoder().encode("123"), RoleEnum.valueOf("USER"));
            User superAdmin = new User("Allayev Sanjar", "superadmin", generator.passwordEncoder().encode("123"), RoleEnum.valueOf("SUPER_ADMIN"));
            User admin = new User("Sanjar", "admin", generator.passwordEncoder().encode("123"), RoleEnum.valueOf("ADMIN"));
            userRepository.save(user);
            userRepository.save(superAdmin);
            userRepository.save(admin);
        }
    }
}
