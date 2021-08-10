package ru.itis.education.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto {
    private Long id;
    private String title;
    private UserDto teacher;
    private List<LessonDto> lessons;

    public static CourseDto from(Course course) {
        CourseDto result = CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .build();

        if (course.getTeacher() != null) {
            result.setTeacher(UserDto.from(course.getTeacher()));
        }

        if (course.getLessons() != null) {
            result.setLessons(LessonDto.from(course.getLessons()));
        }

        return result;

    }

    public static List<CourseDto> from(List<Course> courses) {
        return courses.stream().map(CourseDto::from).collect(Collectors.toList());
    }
}

