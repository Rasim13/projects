package ru.itis.manageUsers.dto;

import lombok.Data;

/**
 * Вспомонательный класс, для передачи объекта auth между подсистемами
 */
@Data
public class AuthDto {
    private String email;
    private String hashPassword;
}
