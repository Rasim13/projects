package ru.itis.manageUsers.forms;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

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
