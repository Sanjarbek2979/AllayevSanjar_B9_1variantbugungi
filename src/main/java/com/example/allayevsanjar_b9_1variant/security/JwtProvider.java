package com.example.allayevsanjar_b9_1variant.security;

import com.example.allayevsanjar_b9_1variant.entity.User;
import com.example.allayevsanjar_b9_1variant.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Optional;

@Component
public class JwtProvider {
    @Autowired
    UserRepository userRepository;
    @Value("${app.jwt.secret}")
    String secretKey ;
    @Value("${app.jwt.expireTime}")
    long expire;

    public String generateToken(String username) {

        Optional<User> byUserName = userRepository.findByUsername(username);
        if (byUserName.isPresent()){
            return Jwts.builder()
                    .signWith(SignatureAlgorithm.HS512,secretKey)
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expire))
                    .compact();
        }
        return "Bunday username li foydalanuvchi yo'q";

    }

   public String getUserNameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
   }

    public boolean expireToken(String token) {
        try {

            Date expiration = Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration();
            return expiration.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
