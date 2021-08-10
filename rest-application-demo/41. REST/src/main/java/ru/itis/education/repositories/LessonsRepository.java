package ru.itis.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.education.models.Lesson;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}
