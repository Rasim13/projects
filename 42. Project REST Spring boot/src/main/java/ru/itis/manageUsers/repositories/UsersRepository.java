package ru.itis.manageUsers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.manageUsers.models.User;

import java.util.Optional;

/**
 * Интерфейс, ползволяющий делать запросы в БД
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    /**
     * Метод для поиска по email
     */
    Optional<User> findByEmail(String email);

    /**
     * Метод для поиска токена
     */
    Optional<User> findByTokens_Value(String value);

    /**
     * Метод для поиска пользователя по имени
     */
    Optional<User> findUserByFirstNameContaining(String firstName);

    /**
     * Метод для поиска пользователя по фамилии
     */
    Optional<User> findUserByLastNameContaining(String lastName);
}
