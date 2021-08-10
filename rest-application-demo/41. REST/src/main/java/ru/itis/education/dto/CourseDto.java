package ru.itis.education.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.education.models.Course;
import ru.itis.education.models.Lesson;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String title;
    private UserDto teacher;
    private List<LessonDto> lessons;

    public static CourseDto from(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .teacher(UserDto.from(course.getTeacher()))
                .lessons(LessonDto.from(course.getLessons()))
                .build();
    }

    public static List<CourseDto> from(List<Course> courses) {
        return courses.stream().map(CourseDto::from).collect(Collectors.toList());
    }
}

