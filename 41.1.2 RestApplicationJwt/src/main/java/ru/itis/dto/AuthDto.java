package ru.itis.dto;


import lombok.Data;

@Data
public class AuthDto {

    private String email;
    private String hashPassword;
}
