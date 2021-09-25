package ru.itis.manageUsers.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.forms.UserForm;
import ru.itis.manageUsers.services.UserService;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * Контроллер для управление пользователем
 */

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    /**
     * Метод для добавления пользователя
     */
    @ApiOperation(value = "Добавление пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = UserDto.class)})
    @PermitAll
    @PostMapping("/users")
    public UserDto adduser (@RequestBody UserForm userForm) {
        return userService.addUser(userForm);
    }

    /**
     * Метод для получения пользователей
     */
    @ApiOperation(value = "Получение пользователей")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = UserDto.class)})
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    /**
     * Метод для удаления пользователя
     */
    @ApiOperation(value = "Удаление пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = UserDto.class)})
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "users/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> deleteUser(@PathVariable ("user-id") Long userId) {
        return userService.deleteUserById(userId);
    }

    /**
     * Метод для обновления данных пользователя
     */
    @ApiOperation(value = "Обновление данных пользователя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = UserDto.class)})
    @PermitAll
    @PutMapping(value = "users/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@PathVariable ("user-id") Long userId, @RequestBody UserForm userFom) {
        return userService.updateUser(userId, userFom);
    }

    /**
     * Метод для поиска пользователя по имени
     */
    @ApiOperation(value = "Получение пользователя по имени")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = UserDto.class)})
    @PermitAll
    @GetMapping(value = "users/firstName", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findUserByFirstName(@RequestParam("firstName") String firstName) {
        return userService.findUserByName(firstName);
    }


    /**
     * Метод для поиска пользователя по фамилии
     */
    @ApiOperation(value = "Получение пользователя по фамилии")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно выполнено", response = UserDto.class)})
    @PermitAll
    @GetMapping(value = "users/lastName", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUserByLastName(@RequestParam("lastName") String lastName) {
        return userService.findUserByLastName(lastName);
    }
}
