package ru.itis.hibernate.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.itis.hibernate.models.Course;
import ru.itis.hibernate.models.Lesson;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Course java = Course.builder()
                .title("java")
                .build();

        Lesson sqlLesson = Lesson.builder()
                .course(java)
                .name("Урок по SQl")
                .build();

        Lesson springLesson = Lesson.builder()
                .course(java)
                .name("Урок по Spring")
                .build();

        Lesson hibernateLesson = Lesson.builder()
                .course(java)
                .name("Урок по Hibernate")
                .build();

        session.save(java);
        session.save(sqlLesson);
        session.save(springLesson);
        session.save(hibernateLesson);
        session.close();

        session = sessionFactory.openSession();

        Query<Course> query = session.createQuery("from Course course where course.title = 'Java'",Course.class);
        Course courseFromDb = query.getSingleResult();
        System.out.println(courseFromDb);
        session.close();
    }
}
