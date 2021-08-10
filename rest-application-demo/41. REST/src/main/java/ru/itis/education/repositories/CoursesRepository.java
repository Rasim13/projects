package ru.itis.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.education.models.Course;
import ru.itis.education.models.User;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByTeacher(User teacher);
}
