package ru.itis.manageUsers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Модель пользователя
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    /**
     * Поле ролей
     */
    public enum Role {
        ADMIN, USER
    }

    /**
     * Поле id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Поле имя пользователя
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Поле фамилия пользователя
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Поле день рождение пользователя
     */
    @Column(name = "birthday")
    private Date birthday;

    /**
     * Поле email пользователя
     */
    @Column(name = "email")
    private String email;

    /**
     *Поле пароль пользователя
     */
    @Column(name = "hash_password")
    private String hashPassword;

    /**
     * Поле адрес пользователя
     */
    @Column(name = "address")
    private String address;

    /**
     *Поле ссылка на роли пользователя
     */
    @Enumerated(value = EnumType.STRING)
    private Role role;

    /**
     * Поле о себе пользователя
     */
    @Column(name = "about_myself")
    private String aboutMyself;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;
}
