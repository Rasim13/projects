package ru.itis.education.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalTime startTime;
    private LocalTime finishTime;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Enumerated(value = EnumType.STRING)
    private DayOfWeek dayOfWeek;
}
