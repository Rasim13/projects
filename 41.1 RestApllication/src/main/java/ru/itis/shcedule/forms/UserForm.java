package ru.itis.shcedule.forms;

import lombok.Data;
import ru.itis.shcedule.models.Event;

import java.util.List;

@Data
public class UserForm {

    private String email;
    private String name;
}
