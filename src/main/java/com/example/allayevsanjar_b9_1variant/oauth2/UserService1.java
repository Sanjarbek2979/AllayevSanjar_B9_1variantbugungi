package com.example.allayevsanjar_b9_1variant.oauth2;

import com.example.allayevsanjar_b9_1variant.entity.User;
import com.example.allayevsanjar_b9_1variant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService1 {

    @Autowired
    private UserRepository repo;

    public void processOAuthPostLogin(String username) {
        User existUser = repo.getUserByUsername(username);

        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setActive(true);
            repo.save(newUser);
        }

    }
}