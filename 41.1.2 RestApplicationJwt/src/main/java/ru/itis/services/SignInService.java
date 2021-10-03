package ru.itis.services;

import ru.itis.dto.AuthDto;
import ru.itis.dto.JwtTokenDto;
import ru.itis.dto.UserDto;

public interface SignInService {
    JwtTokenDto signIn(AuthDto auth);
}
