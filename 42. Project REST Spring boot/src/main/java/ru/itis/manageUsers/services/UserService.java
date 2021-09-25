package ru.itis.manageUsers.services;

import ru.itis.manageUsers.dto.UserDto;
import ru.itis.manageUsers.forms.UserForm;
import java.util.List;

/**
 * Интерфейс, позволяющий управлять пользователем
 */

public interface UserService {
    /**
     * Метод для добваления пользователя
     */
    UserDto addUser(UserForm user);

    /**
     * Метод для получения список пользователей
     */
    List<UserDto> getUsers();

    /**
     * Метод для удаления пользователя по id
     */
    List<UserDto> deleteUserById(Long userId);

    /**
     * Метод для обновления данных о пользователе
     */
    UserDto updateUser(Long userId, UserForm userFom);

    /**
     * Метод для поиска пользователя по имени
     */
    UserDto findUserByName(String firstName);

    /**
     * Метод для поиска пользователя по фамилии
     */
    UserDto findUserByLastName(String lastName);
}
