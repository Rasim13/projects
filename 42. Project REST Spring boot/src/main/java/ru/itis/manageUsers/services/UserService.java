package ru.itis.manageUsers.services;

import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.forms.UserForm;

import java.util.List;

public interface UserService {
    UserDto addUser(UserForm user);
    List<UserDto> getUsers();
    List<UserDto> deleteUserById(Long userId);
    UserDto updateUser(Long userId, UserForm userFom);
    UserDto findUserByName(String firstName);
    UserDto findUserByLastName(String lastName);
}
