package ru.itis.shcedule.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.shcedule.dto.EventDto;
import ru.itis.shcedule.forms.EventForm;
import ru.itis.shcedule.models.User;
import ru.itis.shcedule.services.EventsService;

@RestController
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @ApiOperation(value = "Добавление события")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = EventDto.class)})
    @PostMapping("/events/{user-id}")
    public EventDto addEventToUser(@RequestBody EventForm event, @PathVariable("user-id") Long userId) {
        return eventsService.addEventToUser(event, userId);
    }

    @PostMapping("/events")
    public EventDto addEventToSeveralUsers(@RequestBody EventForm event) {
        return eventsService.addEventToSeveralUsers (event);
    }

}
