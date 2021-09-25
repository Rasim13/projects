package ru.itis.manageUsers.services;

import ru.itis.manageUsers.dto.AuthDto;
import ru.itis.manageUsers.dto.TokenDto;

/**
 * Интерфейс, позволяющий авторизоваться пользователю
 */
public interface SignInService {

    TokenDto signIn(AuthDto auth);
}
