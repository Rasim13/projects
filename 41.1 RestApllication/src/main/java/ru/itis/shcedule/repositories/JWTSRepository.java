package ru.itis.shcedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.shcedule.models.JWTToken;

public interface JWTSRepository extends JpaRepository<JWTToken, Long> {

}
