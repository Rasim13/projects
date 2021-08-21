package ru.itis.shcedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.forms.EventForm;
import ru.itis.shcedule.models.Event;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.repositories.EventsRepositories;
import ru.itis.shcedule.repositories.UsersRepositories;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import static ru.itis.shcedule.dto.EventDto.from;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepositories eventsRepositories;

    @Autowired
    private UsersRepositories usersRepositories;

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

    @Override
    public EventDto addEventToUser(EventForm event, Long userId) {
        Event newEvent = null;
        User user = null;

        boolean checkTime;

        user = usersRepositories.findById(userId).orElseThrow(IllegalArgumentException::new);

        checkTime = getTimeCheck(event, userId);

        if (user == null) {

            throw new IllegalArgumentException("User doesn't exist with " + userId);
        }


            newEvent = Event.builder()
                    .date(LocalDate.parse(event.getDate()))
                    .nameOfTheEvent(event.getNameOfTheEvent())
                    .startTime(LocalTime.parse(event.getStartTime()))
                    .finishTime(LocalTime.parse(event.getFinishTime()))
                    .build();

            user.addEventToUser(newEvent);

            eventsRepositories.save(newEvent);


        return from(newEvent);
    }

    public boolean getTimeCheck (EventForm eventForm, Long userId) {
        User user = usersRepositories.findById(userId).orElseThrow(IllegalArgumentException::new);

//        List<Event> events = eventsRepositories.findById(user.getId()).orElseThrow(IllegalArgumentException::new);
//
//        for (Event findEvent:events) {
//            if (eventForm.getDate().equals(findEvent.getDate()) && !eventForm.getStartTime().equals(findEvent.getStartTime())) {
//                return true;
//            }
//        }
        return false;
    }
}
