package ru.itis.shcedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shcedule.models.Event;
import ru.itis.shcedule.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByTokens_Value(String value);

    Optional<User> findByJwtTokens_Value(String value);

//    List<Event> findByUser(User user);
}
