package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.EventDto;
import ru.itis.forms.EventForm;
import ru.itis.models.Event;
import ru.itis.models.User;
import ru.itis.repositories.EventsRepository;
import ru.itis.repositories.UsersRepository;

import java.util.List;

import static ru.itis.dto.EventDto.from;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public EventDto addEventToUser(EventForm event, Long userId) {

        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);

       boolean checkTime = checkTime(event, user);

        if (checkTime) {
            throw new IllegalArgumentException("You can't add event this time");
        }
        Event newEvent = Event.builder()
                .date(event.getDate())
                .nameOfTheEvent(event.getNameOfTheEvent())
                .startTime(event.getStartTime())
                .finishTime(event.getFinishTime())
                .build();

        user.addEventToUser(newEvent);

        eventsRepository.save(newEvent);

        return from(newEvent);
    }

    @Override
    public EventDto addEventToSeveralUsers(EventForm event) {

        User user = null;
        Event newEvent = null;
        List<User> users = event.getUsers();

        for (User findUser: users) {
            user = usersRepository.findById(findUser.getId()).orElseThrow(IllegalArgumentException::new);

            boolean checkTime = checkTime(event, user);

            if (user == null) {
                throw new IllegalArgumentException();
            }

            if (checkTime) {
                throw new IllegalArgumentException("You can't add event this time");
            }
                newEvent = Event.builder()
                        .date(event.getDate())
                        .nameOfTheEvent(event.getNameOfTheEvent())
                        .startTime(event.getStartTime())
                        .finishTime(event.getFinishTime())
                        .build();

                user.addEventToUser(newEvent);
                eventsRepository.save(newEvent);
        }
        return from(newEvent);
    }

    public boolean checkTime (EventForm eventForm, User user) {
        List<Event> events = user.getEvents();

        if (events == null) {
            throw new IllegalArgumentException("no events");
        }
        for (Event findEvent:events) {
            if (findEvent.getDate().equals(eventForm.getDate())
                    && findEvent.getStartTime().equals(eventForm.getStartTime())
                        && findEvent.getFinishTime().equals(eventForm.getFinishTime())) {
                return true;
            }
            if (findEvent.getDate().equals(eventForm.getDate())
                    && eventForm.getStartTime().isAfter(findEvent.getStartTime())
                        && eventForm.getStartTime().isBefore(findEvent.getFinishTime())) {
                return true;
            }

            if (findEvent.getDate().equals(eventForm.getDate())
                    && eventForm.getStartTime().isBefore(findEvent.getStartTime())
                        && eventForm.getFinishTime().isAfter(findEvent.getStartTime())) {
                return true;
            }

        }
        return false;
    }
}
