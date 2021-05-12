package repositories;

import models.Student;

import java.util.List;

public interface StudentRepositories {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void update(Student student);
    void deleteById(Integer id);
    void sortById();
    void sortByRaiting();
    void sortByAge();

}
