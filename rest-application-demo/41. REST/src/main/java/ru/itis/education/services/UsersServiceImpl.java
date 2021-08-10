package ru.itis.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.education.dto.CourseDto;
import ru.itis.education.dto.UserDto;
import ru.itis.education.models.Course;
import ru.itis.education.models.User;
import ru.itis.education.repositories.CoursesRepository;
import ru.itis.education.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

import static ru.itis.education.dto.CourseDto.from;
import static ru.itis.education.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public List<CourseDto> getCoursesByUser(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        if (user.isTeacher()) {
            return from(coursesRepository.findAllByTeacher(user));
        } else {
            return from(coursesRepository.findAllByStudents_Id(userId));
        }
    }

    @Override
    public List<CourseDto> deleteCourseFromUser(Long userId, Long courseId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        Course course = coursesRepository.findById(courseId).orElseThrow(IllegalArgumentException::new);

        if (user.isTeacher() && course.ofTeacher(user)) {
            course.setTeacher(null);
        } else {
            course.getStudents().remove(user);
        }
        coursesRepository.save(course);

        return getCoursesByUser(userId);
    }
}
