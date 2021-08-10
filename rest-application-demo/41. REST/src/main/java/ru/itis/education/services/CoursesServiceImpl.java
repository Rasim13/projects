package ru.itis.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.education.dto.CourseDto;
import ru.itis.education.forms.CourseForm;
import ru.itis.education.models.Course;
import ru.itis.education.repositories.CoursesRepository;

import java.time.LocalDate;
import java.util.List;

import static ru.itis.education.dto.CourseDto.from;

@Service
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public CourseDto addCourse(CourseForm course) {
        Course newCourse = Course.builder()
                .startDate(LocalDate.parse(course.getStartDate()))
                .finishDate(LocalDate.parse(course.getFinishDate()))
                .title(course.getTitle())
                .build();
        coursesRepository.save(newCourse);
        return from(newCourse);
    }

    @Override
    public CourseDto updateCourse(Long courseId, CourseForm course) {
        Course courseForUpdate = coursesRepository.getById(courseId);

        updateCourse(course, courseForUpdate);
        coursesRepository.save(courseForUpdate);
        return from(coursesRepository.getById(courseId));
    }

    private void updateCourse(CourseForm course, Course courseForUpdate) {
        courseForUpdate.setTitle(course.getTitle());
        courseForUpdate.setStartDate(LocalDate.parse(course.getStartDate()));
        courseForUpdate.setFinishDate(LocalDate.parse(course.getFinishDate()));
    }

}
