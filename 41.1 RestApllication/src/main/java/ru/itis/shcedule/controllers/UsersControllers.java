package ru.itis.shcedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.dto.UserDto;
import ru.itis.shcedule.forms.UserForm;
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

    @GetMapping(value = "/user/{user-id}/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDto> getEventsByUser(@PathVariable("user-id") Long userId) {
        return usersService.getEventsByUser(userId);
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserForm userForm) {
        return usersService.addUser(userForm);
    }
}
