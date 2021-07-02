package ru.itis.repositories;

import ru.itis.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentsRepositoryJpaImpl implements StudentsRepository {

    private EntityManager entityManager;

    public StudentsRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        transaction.commit();
    }
}
