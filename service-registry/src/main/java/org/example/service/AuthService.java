package org.example.service;

import org.example.model.UserCredential;
import org.example.repository.UserCredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserCredentialRepository userCredentialRepository;
    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;

    public String saveUser(UserCredential userCredential){
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        return userCredentialRepository.save(userCredential).toString();
    }

    public String createToken(String username){
        return jwtService.createToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
