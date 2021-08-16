package ru.itis.shcedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.UserDto;
import ru.itis.shcedule.repositories.UsersRepositories;

import java.util.List;

import static ru.itis.shcedule.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepositories usersRepositories;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepositories.findAll());
    }
}
