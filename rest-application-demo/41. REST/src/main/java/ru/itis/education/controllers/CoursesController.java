package ru.itis.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.itis.education.dto.CourseDto;
import ru.itis.education.forms.CourseForm;
import ru.itis.education.services.CoursesService;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @PostMapping
    public CourseDto addCourse(@RequestBody CourseForm course) {
        return coursesService.addCourse(course);
    }

    @PutMapping("/{course-id}")
    public CourseDto updateCourse(@PathVariable("course-id") Long courseId, @RequestBody CourseForm course) {
        return coursesService.updateCourse(courseId, course);
    }
}
