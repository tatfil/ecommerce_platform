package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.UserCredential;
import org.example.repository.UserCredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String saveUser(UserCredential userCredential){
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepository.save(userCredential);
        return "User added to the system";
    }

    public String createToken(String username){
        return jwtService.createToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
