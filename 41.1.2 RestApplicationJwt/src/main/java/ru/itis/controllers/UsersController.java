package ru.itis.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.EventDto;
import ru.itis.dto.TimeDto;
import ru.itis.dto.UserDto;
import ru.itis.forms.UserForm;
import ru.itis.models.Time;
import ru.itis.services.UsersService;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "Получение пользователей")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = UserDto.class)})
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers(@RequestHeader("Authorization") String auth) {
        return usersService.getUsers();
    }

//    @GetMapping(value = "/user/{user-id}/events", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<EventDto> getEventsByUser(@PathVariable("user-id") Long userId) {
//        return usersService.getEventsByUser(userId);
//    }

    @ApiOperation(value = "Добавление пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = UserDto.class)})
    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserForm userForm) {
        return usersService.addUser(userForm);
    }


    @ApiOperation(value = "Получение событий нескольких пользователей")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = EventDto.class)})
    @GetMapping(value = "/user/{user-id}/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventDto> getEventsSeveralUsers(@PathVariable("user-id") Long userId) {
        return usersService.getEventsByUser(userId);
    }

    @ApiOperation(value = "Получение общего времени несколько пользователей")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = TimeDto.class)})
    @GetMapping(value = "/users/events/time", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeDto getEventsSeveralUsers(@RequestBody Time time) {
        return null;
//        return usersService.getGeneralTime(time);
    }
}
