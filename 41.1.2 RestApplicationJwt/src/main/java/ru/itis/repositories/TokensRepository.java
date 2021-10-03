package ru.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.models.Token;

public interface TokensRepository extends JpaRepository<Token, Long> {
}
