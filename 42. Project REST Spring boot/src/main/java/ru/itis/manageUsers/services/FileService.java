package ru.itis.manageUsers.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.manageUsers.dto.UserDto;
import java.util.List;

/**
 * Интерфейс, позволяющий загружать данные о пользователе
 */

public interface FileService {

    List<UserDto> save(MultipartFile file);
}
