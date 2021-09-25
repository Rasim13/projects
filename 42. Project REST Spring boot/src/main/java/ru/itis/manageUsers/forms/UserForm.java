package ru.itis.manageUsers.forms;

import lombok.Data;
import java.util.Date;

/**
 * Класс, для получения входных данных о пользователе
 */

@Data
public class UserForm {

    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;
    private String hashPassword;
    private String address;
    private String aboutMyself;
}
