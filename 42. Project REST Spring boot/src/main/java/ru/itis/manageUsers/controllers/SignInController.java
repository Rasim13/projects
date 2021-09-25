package ru.itis.manageUsers.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.manageUsers.dto.AuthDto;
import ru.itis.manageUsers.dto.TokenDto;
import ru.itis.manageUsers.services.SignInService;

import javax.annotation.security.PermitAll;

/**
 * Контроллер для авторизации пользователей
 */
@RestController
public class SignInController {

    @Autowired
    private SignInService signInService;

    /**
     * Метод для авторизации пользователей
     */
    @ApiOperation(value = "Авторизация пользователя")
    @PermitAll
    @PostMapping("/signIn")
    public TokenDto signIn(@RequestBody AuthDto auth) {
        return signInService.signIn(auth);
    }

}
