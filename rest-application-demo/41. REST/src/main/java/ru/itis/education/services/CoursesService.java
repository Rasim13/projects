package ru.itis.education.services;

import ru.itis.education.dto.CourseDto;
import ru.itis.education.forms.CourseForm;

import java.util.List;

public interface CoursesService {
    CourseDto addCourse(CourseForm course);
    CourseDto updateCourse(Long courseId, CourseForm course);
}
