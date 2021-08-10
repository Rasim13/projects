package ru.itis.education.services;

import ru.itis.education.dto.CourseDto;
import ru.itis.education.dto.UserDto;
import ru.itis.education.models.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();
    List<CourseDto> getCoursesByUser(Long UserId);

    List<CourseDto> deleteCourseFromUser(Long userId, Long courseId);
}
