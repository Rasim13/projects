package ru.itis.shcedule.services;

import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.forms.EventForm;

public interface EventsService {
    EventDto addEvent(EventForm event);
}
