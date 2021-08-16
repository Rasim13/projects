package ru.itis.shcedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.forms.EventForm;
import ru.itis.shcedule.services.EventsService;

@RestController
public class EventsControllers {

    @Autowired
    private EventsService eventsService;

    @PostMapping("/events")
    public EventDto addEvent(@RequestBody EventForm event) {
        return eventsService.addEvent(event);
    }
}
