package ru.itis.education.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.education.dto.CourseDto;
import ru.itis.education.models.Course;
import ru.itis.education.models.User;
import ru.itis.education.repositories.CoursesRepository;
import ru.itis.education.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static ru.itis.education.dto.CourseDto.from;


@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping(value = "/users/{user-id}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDto> getCoursesByUser(@PathVariable("user-id") Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        if (user.isTeacher()) {
            return from(coursesRepository.findAllByTeacher(user));
        } else {
            return new ArrayList<>();
        }
    }


}
