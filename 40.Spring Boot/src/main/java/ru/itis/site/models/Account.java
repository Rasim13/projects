package ru.itis.site.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {

    public enum State {
        CONFIRMED, NOT_CONFIRMED, BANNED
    }

    public enum Role {
        ADMIN, USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
//    private Integer experience;
    private String email;
    @Column(name = "hash_password")
    private String hashPassword;

    @Enumerated(value = EnumType.STRING) //для конвертации enum в строку в БД
    private State state;

    @Enumerated(value = EnumType.STRING) //для конвертации enum в строку в БД
    private Role role;

    private String confirmId;

//    @ManyToMany (mappedBy = "drivers")
//    private List<Car> cars;

}
