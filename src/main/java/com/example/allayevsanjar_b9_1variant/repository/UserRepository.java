package com.example.allayevsanjar_b9_1variant.repository;

import com.example.allayevsanjar_b9_1variant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, пт 8:52. 08.04.2022
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    User getUserByUsername(String username);
}
