package ru.itis.shcedule.forms;

import lombok.Data;

@Data
public class UserForm {

    private String email;
    private String name;
    private String hashPassword;

}
