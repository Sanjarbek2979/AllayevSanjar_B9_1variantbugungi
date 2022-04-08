package com.example.allayevsanjar_b9_1variant.service;

import com.example.allayevsanjar_b9_1variant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Sanjarbek Allayev, пт 8:51. 08.04.2022
 */
@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).get();

    }
}
