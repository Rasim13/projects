package ru.itis.shcedule.forms;

import lombok.Data;

@Data
public class EventForm {

    private String nameOfTheEvent;
    private String startTime;
    private String finishTime;
    private String date;
}
