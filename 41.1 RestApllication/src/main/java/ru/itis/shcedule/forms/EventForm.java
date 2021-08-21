package ru.itis.shcedule.forms;

import lombok.Data;
import ru.itis.shcedule.models.User;

@Data
public class EventForm {

    private String nameOfTheEvent;
    private String startTime;
    private String finishTime;
    private String date;
    private User user;
}
