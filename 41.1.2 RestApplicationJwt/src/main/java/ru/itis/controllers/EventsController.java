package ru.itis.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dto.EventDto;
import ru.itis.forms.EventForm;
import ru.itis.services.EventsService;

@RestController
public class EventsController {

    private EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @ApiOperation(value = "Добавление события пользователю")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = EventDto.class)})
    @PostMapping("/events/{user-id}")
    public EventDto addEventToUser(@RequestBody EventForm event, @PathVariable("user-id") Long userId) {
        return eventsService.addEventToUser(event, userId);
    }

    @ApiOperation(value = "Добавление события нескольким пользователям")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = EventDto.class)})
    @PostMapping("/events")
    public EventDto addEventToSeveralUsers(@RequestBody EventForm event) {
        return eventsService.addEventToSeveralUsers (event);
    }

}
