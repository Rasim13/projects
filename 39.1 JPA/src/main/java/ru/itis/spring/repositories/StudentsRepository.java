package ru.itis.spring.repositories;

import ru.itis.spring.models.Student;

public interface StudentsRepository {
    void save(Student student);
}
