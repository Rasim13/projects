package ru.itis.manageUsers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.manageUsers.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByTokens_Value(String value);
    Optional<User> findUserByFirstNameContaining(String firstName);
    Optional<User> findUserByLastNameContaining(String lastName);
}
