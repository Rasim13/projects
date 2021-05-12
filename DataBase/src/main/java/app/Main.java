package app;

import models.Student;
import repositories.StudentFileRepositories;
import repositories.StudentFileRepositoriesImpl;
import repositories.StudentRepositories;
import repositories.StudentRepositoriesJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","sql2021");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        StudentRepositories studentRepositories = new StudentRepositoriesJdbcImpl(connection);
        StudentFileRepositories outputInformationStudent = new StudentFileRepositoriesImpl("InformationAboutStudent.txt");
        List<Student> studentList = studentRepositories.findAll();
        outputInformationStudent.writeToFile(studentList);
//        System.out.println(studentRepositories.findAll());
//        System.out.println(studentRepositories.findById(1));
//        studentRepositories.sortById();
//        System.out.println();
//        studentRepositories.sortByRaiting();
    }
}
