package ru.itis.shcedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.shcedule.dto.UserDto;
import ru.itis.shcedule.services.UsersService;

import java.util.List;

@RestController
public class UsersControllers {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers() {
        return usersService.getUsers();
    }
}
