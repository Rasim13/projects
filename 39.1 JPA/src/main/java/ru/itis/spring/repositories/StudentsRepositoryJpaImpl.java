package ru.itis.spring.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.spring.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StudentsRepositoryJpaImpl implements StudentsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
