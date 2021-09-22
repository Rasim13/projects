package ru.itis.manageUsers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.forms.UserForm;
import ru.itis.manageUsers.services.UserService;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController("api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PermitAll
    @PostMapping("/users")
    public UserDto adduser (@RequestBody UserForm userForm) {
        return userService.addUser(userForm);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> deleteUser(@PathVariable ("user-id") Long userId) {
        return userService.deleteUserById(userId);
    }

    @PermitAll
    @PutMapping(value = "/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@PathVariable ("user-id") Long userId, @RequestBody UserForm userFom) {
        return userService.updateUser(userId, userFom);
    }

    @PermitAll
    @GetMapping(value = "/firstName", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findUserByFirstName(@RequestParam("firstName") String firstName) {
        return userService.findUserByName(firstName);
    }

    @PermitAll
    @GetMapping(value = "/lastName", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUserByLastName(@RequestParam("lastName") String lastName) {
        return userService.findUserByLastName(lastName);
    }
}
