package ru.itis.shcedule.services;

import ru.itis.shcedule.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

}
