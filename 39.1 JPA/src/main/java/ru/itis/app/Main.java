package ru.itis.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.itis.models.Course;
import ru.itis.models.Student;
import ru.itis.repositories.CourseRepository;
import ru.itis.repositories.CourseRepositoryJpaImpl;
import ru.itis.repositories.StudentsRepository;
import ru.itis.repositories.StudentsRepositoryJpaImpl;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();

        CourseRepository courseRepository = new CourseRepositoryJpaImpl(entityManager);
        StudentsRepository studentsRepository = new StudentsRepositoryJpaImpl(entityManager);

        Course java = Course.builder()
                .title("Java")
//                .students(Arrays.asList(airat, aliya, maxim, marsel,adelya))
                .build();
        Course sql = Course.builder()
                .title("SQL")
//                .students(Arrays.asList(airat, maxim))
                .build();

        Course python = Course.builder()
                .title("Python")
//                .students(Collections.singletonList(adelya))
                .build();
        courseRepository.save(java);
        courseRepository.save(sql);
        courseRepository.save(python);


        Student marsel = Student.builder()
                .firstName("Марсель")
                .lastName("f1")
                .courses(Arrays.asList(java, sql))
                .build();

        Student airat = Student.builder()
                .firstName("Айрат")
                .lastName("f2")
                .courses(Arrays.asList(java, sql))
                .build();

        Student aliya = Student.builder()
                .firstName("Алия")
                .lastName("f3")
                .courses(Collections.singletonList(java))
                .build();

        Student maxim = Student.builder()
                .firstName("Максим")
                .lastName("f4")
                .courses(Arrays.asList(java, sql))
                .build();

        Student adelya = Student.builder()
                .firstName("Аделя")
                .courses(Arrays.asList(java, python))
                .lastName("f3")
                .build();

        studentsRepository.save(marsel);
        studentsRepository.save(maxim);
        studentsRepository.save(aliya);
        studentsRepository.save(airat);
        studentsRepository.save(adelya);

        System.out.println(courseRepository.findAllStudentsCount(5));

//        entityManager.close();
    }

}
