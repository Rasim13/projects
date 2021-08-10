package ru.itis.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.education.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
