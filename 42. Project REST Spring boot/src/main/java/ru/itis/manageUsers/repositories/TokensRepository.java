package ru.itis.manageUsers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.manageUsers.models.Token;

/**
 * Интерфейс, позволяющий делать запросы в БД
 */
public interface TokensRepository extends JpaRepository<Token, Long> {
}
