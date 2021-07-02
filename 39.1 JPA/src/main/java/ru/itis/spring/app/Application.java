package ru.itis.spring.app;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.itis.spring.config.JpaConfig;
import ru.itis.spring.models.Course;
import ru.itis.spring.models.Student;
import ru.itis.spring.repositories.CoursesRepository;
import ru.itis.spring.repositories.StudentsRepository;

import java.util.Arrays;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        StudentsRepository studentsRepository = context.getBean(StudentsRepository.class);
        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);

        Course java = Course.builder()
                .title("Java")
                .build();
        Course sql = Course.builder()
                .title("SQL")
                .build();

        Course python = Course.builder()
                .title("Python")
                .build();

        coursesRepository.save(java);
        coursesRepository.save(sql);
        coursesRepository.save(python);

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

        System.out.println(coursesRepository.findAllStudentsCount(5));
    }
}
