package org.example.model.dto;

import lombok.*;

import javax.persistence.Entity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthRequest {

    private String username;
    private String password;
}
