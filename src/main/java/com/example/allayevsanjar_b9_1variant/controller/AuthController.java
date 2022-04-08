package com.example.allayevsanjar_b9_1variant.controller;


import com.example.allayevsanjar_b9_1variant.dto.LoginDTO;
import com.example.allayevsanjar_b9_1variant.entity.User;
import com.example.allayevsanjar_b9_1variant.security.CurrentUser;
import com.example.allayevsanjar_b9_1variant.security.JwtProvider;
import com.example.allayevsanjar_b9_1variant.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
        String token=jwtProvider.generateToken(loginDTO.getUserName());
        return ResponseEntity.ok().body(token);
    }
    @GetMapping("/me")
    public HttpEntity<?> getMe(@CurrentUser User user) { //Parametr
        return ResponseEntity.ok().body("Mana" + user);
    }

}
