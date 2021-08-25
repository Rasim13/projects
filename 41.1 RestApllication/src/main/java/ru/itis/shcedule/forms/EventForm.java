package ru.itis.shcedule.forms;

import lombok.Data;
import ru.itis.shcedule.models.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class EventForm {

    private String nameOfTheEvent;
    private LocalTime startTime;
    private LocalTime finishTime;
    private LocalDate date;
    List<User> users;
}
