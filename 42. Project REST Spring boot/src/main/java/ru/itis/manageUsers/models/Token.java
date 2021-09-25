package ru.itis.manageUsers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Модель токена
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Token {

    /**
     * Поле id токена
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Поле значение токена
     */
    private String value;

    /**
     * Поле ссылка на конктретного пользователя
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
