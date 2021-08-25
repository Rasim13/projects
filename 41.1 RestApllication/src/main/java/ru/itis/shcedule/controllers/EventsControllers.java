package ru.itis.shcedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.forms.EventForm;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.services.EventsService;

@RestController
public class EventsControllers {

    @Autowired
    private EventsService eventsService;

    @PostMapping("/events/{user-id}")
    public EventDto addEventToUser(@RequestBody EventForm event, @PathVariable("user-id") Long userId) {
        return eventsService.addEventToUser(event, userId);
    }

    @PostMapping("/events")
    public EventDto addEventToSeveralUsers(@RequestBody EventForm event) {
        return eventsService.addEventToSeveralUsers (event);
    }

}
