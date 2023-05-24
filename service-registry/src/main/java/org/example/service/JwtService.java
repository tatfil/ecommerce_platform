package org.example.service;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.example.exception.JwtAuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${spring.security.jwt.token.secret-key}")
    private String secret;
    @Value("${spring.security.jwt.token.header}")
    private String authorizationHeader;
    @Value("${spring.security.jwt.token.expire-length}")
    private Long validityTime;

    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityTime);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("JWT token is expired or invalid!");
        }
    }
}
