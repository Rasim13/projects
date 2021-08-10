package ru.itis.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.education.dto.CourseDto;
import ru.itis.education.dto.UserDto;
import ru.itis.education.services.UsersService;


import java.util.List;


@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping(value = "/users/{user-id}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDto> getCoursesByUser(@PathVariable("user-id") Long userId) {
        return usersService.getCoursesByUser(userId);
    }

    @DeleteMapping(value = "/users/{user-id}/courses/{course-id}")
    public List<CourseDto> deleteCourseFromUser(@PathVariable("user-id") Long userId,
                                                @PathVariable("course-id") Long courseId) {
        return usersService.deleteCourseFromUser(userId, courseId);

    }
}
