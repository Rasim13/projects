package ru.itis.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dto.AuthDto;
import ru.itis.dto.JwtTokenDto;
import ru.itis.dto.UserDto;
import ru.itis.services.SignInService;

import javax.annotation.security.PermitAll;

@RestController
public class SignInController {

    @Autowired
    private SignInService signInService;


    @ApiOperation(value = "Авторизация пользователя")
    @PermitAll
    @PostMapping("/signIn")
    public JwtTokenDto signIn(@RequestBody AuthDto auth) {
        return signInService.signIn(auth);
    }
}
