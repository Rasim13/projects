package ru.itis.repositories;

import ru.itis.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CourseRepositoryJpaImpl implements CourseRepository {

    private EntityManager entityManager;

    public CourseRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Course course) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(course);
        transaction.commit();
    }

    @Override
    public List<Course> findAllStudentsCount(int count) {
       return entityManager.createQuery("select course from Course course where course.students.size = ?1",
                Course.class)
                .setParameter(1, count)
                .getResultList();
    }
}
