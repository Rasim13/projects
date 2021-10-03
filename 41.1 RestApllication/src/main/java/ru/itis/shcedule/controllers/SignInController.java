package ru.itis.shcedule.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.shcedule.dto.AuthDto;
import ru.itis.shcedule.dto.TokenDto;
import ru.itis.shcedule.services.SignInService;

import javax.annotation.security.PermitAll;

@RestController
public class SignInController {

    @Autowired
    private SignInService signInService;

    @ApiOperation(value = "Авторизация пользователя")
    @PermitAll
    @PostMapping("/signIn")
    public TokenDto signIn(@RequestBody AuthDto auth) {
        return signInService.signIn(auth);
    }

}
