package ru.itis.manageUsers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.models.User;
import ru.itis.manageUsers.repositories.UsersRepository;
import ru.itis.manageUsers.utils.ExcelHelper;

import java.io.IOException;
import java.util.List;

import static ru.itis.manageUsers.dto.UserDto.from;

/**
 * Реализация интерфейса загрузки данных по пользователе из файла excel
 */

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Метод сохраняет список пользователей
     */
    @Override
    public List<UserDto> save(MultipartFile file) {
        try {
            List<User> users = ExcelHelper.excelToUsers(file.getInputStream());
            usersRepository.saveAll(users);
            return from(users);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
