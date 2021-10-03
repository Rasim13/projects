package ru.itis.shcedule.services;

import ru.itis.shcedule.dto.AuthDto;
import ru.itis.shcedule.dto.JWTTokenDto;

public interface SignInService {
//    TokenDto signIn(AuthDto auth);
    JWTTokenDto signIn(AuthDto auth);
}
