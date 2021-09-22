package ru.itis.manageUsers.dto;

import lombok.Data;

@Data
public class AuthDto {
    private String email;
    private String hashPassword;
}
