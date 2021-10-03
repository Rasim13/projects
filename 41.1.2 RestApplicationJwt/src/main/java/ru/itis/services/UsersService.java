package ru.itis.services;

import ru.itis.dto.EventDto;
import ru.itis.dto.UserDto;
import ru.itis.forms.UserForm;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    List<EventDto> getEventsByUser(Long userId);

    UserDto addUser(UserForm user);

//    TimeDto getGeneralTime(Time time);

//    List<TimeDto> getTimeByUsers(TimeForm timeForm);
}
