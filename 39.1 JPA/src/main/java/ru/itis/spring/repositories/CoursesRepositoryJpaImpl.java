package ru.itis.spring.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.spring.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CoursesRepositoryJpaImpl implements CoursesRepository {

    @PersistenceContext // предназначена для автоматического связывания entityManager с бином
    private EntityManager entityManager;

    @Transactional // определяет область действия одной транзакции в БД
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public List<Course> findAllStudentsCount(int count) {
       return entityManager.createQuery("select course from Course course where course.students.size = ?1",
                Course.class)
                .setParameter(1, count)
                .getResultList();
    }
}
