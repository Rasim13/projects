package ru.itis.shcedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shcedule.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByTokens_Value(String value);

}
