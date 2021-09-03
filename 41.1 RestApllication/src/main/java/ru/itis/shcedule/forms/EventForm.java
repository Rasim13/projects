package ru.itis.shcedule.forms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ru.itis.shcedule.models.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@ApiModel(description = "Форма события")
@Data
public class EventForm {

    @ApiModelProperty(value = "Название события")
    private String nameOfTheEvent;
    @ApiModelProperty(value = "Начало события")
    private LocalTime startTime;
    @ApiModelProperty(value = "Конец события")
    private LocalTime finishTime;
    @ApiModelProperty(value = "День назначенного события")
    private LocalDate date;
    @ApiModelProperty(value = "Пользователи к которым добавлены события")
    List<User> users;
}
