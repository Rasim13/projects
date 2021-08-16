package ru.itis.shcedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.forms.EventForm;
import ru.itis.shcedule.models.Event;
import ru.itis.shcedule.repositories.EventsRepositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static ru.itis.shcedule.dto.EventDto.from;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepositories eventsRepositories;

    @Override
    public EventDto addEvent(EventForm event) {
        Event newEvent = Event.builder()
                .date(LocalDate.parse(event.getDate()))
                .nameOfTheEvent(event.getNameOfTheEvent())
                .startTime(LocalTime.parse(event.getStartTime()))
                .finishTime(LocalTime.parse(event.getFinishTime()))
                .build();
                eventsRepositories.save(newEvent);
                return from(newEvent);
    }
}
