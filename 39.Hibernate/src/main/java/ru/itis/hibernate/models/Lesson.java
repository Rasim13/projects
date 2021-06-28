package ru.itis.hibernate.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class Lesson {
    private  Long id;
    private String name;

    private Course course;
}
