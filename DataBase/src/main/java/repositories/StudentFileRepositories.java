package repositories;

import models.Student;

import java.util.List;

public interface StudentFileRepositories {
    void writeToFile(List<Student> students);
}
