package ru.itis.manageUsers.services;

import ru.itis.manageUsers.dto.AuthDto;
import ru.itis.manageUsers.dto.TokenDto;

public interface SignInService {

    TokenDto signIn(AuthDto auth);
}
