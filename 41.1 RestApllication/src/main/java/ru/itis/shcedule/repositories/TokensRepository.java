package ru.itis.shcedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shcedule.models.Token;

public interface TokensRepository extends JpaRepository<Token, Long> {
}
