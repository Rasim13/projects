package ru.itis.repositories;

import ru.itis.models.Course;

import java.util.List;

public interface CourseRepository {
    void save(Course course);
    List<Course> findAllStudentsCount(int count);
}
