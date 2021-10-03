package ru.itis.services;

import ru.itis.dto.EventDto;
import ru.itis.forms.EventForm;

public interface EventsService {
//    EventDto addEvent(EventForm event, User user);

    EventDto addEventToUser(EventForm event, Long userId);

    EventDto addEventToSeveralUsers(EventForm event);
}
