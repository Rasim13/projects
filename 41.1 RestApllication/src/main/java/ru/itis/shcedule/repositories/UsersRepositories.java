package ru.itis.shcedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shcedule.models.User;

public interface UsersRepositories extends JpaRepository<User, Long> {

}
