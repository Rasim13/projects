package ru.itis.shcedule.services;

import ru.itis.shcedule.dto.AuthDto;
import ru.itis.shcedule.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(AuthDto auth);
}
