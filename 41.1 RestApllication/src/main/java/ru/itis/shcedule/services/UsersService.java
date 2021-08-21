package ru.itis.shcedule.services;

import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.dto.UserDto;
import ru.itis.shcedule.forms.UserForm;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    List<EventDto> getEventsByUser(Long userId);

    UserDto addUser(UserForm user);
}
