package ru.itis.shcedule.services;

import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.forms.EventForm;
import ru.itis.shcedule.models.User;

public interface EventsService {
//    EventDto addEvent(EventForm event, User user);

    EventDto addEventToUser(EventForm event, Long userId);

    EventDto addEventToSeveralUsers(EventForm event);
}
