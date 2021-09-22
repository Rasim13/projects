package ru.itis.manageUsers.services;

import org.springframework.web.multipart.MultipartFile;

import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.models.User;

import java.util.List;


public interface FileService {

    public List<UserDto> save(MultipartFile file);
}
