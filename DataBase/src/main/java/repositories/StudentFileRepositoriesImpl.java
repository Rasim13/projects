package repositories;

import models.Student;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentFileRepositoriesImpl implements StudentFileRepositories {
    private String path;

    public StudentFileRepositoriesImpl(String path) {
        this.path = path;
    }


    @Override
    public void writeToFile(List<Student> students) {
        BufferedWriter writer = null;
//        List<Student> students = studentRepositoriesJdbc.findAll();
        try {
            writer = new BufferedWriter(new FileWriter(path, true));
            for (Student values : students) {
                writer.write(  values.getId() + " "
                                +  values.getFirstName() + " "
                                +  values.getLastName() + " "
                                +  values.getAge() + " "
                                +  values.getPhone() + " "
                                +  values.getRaiting() + " "
                                +  "\n "
                );
            }
            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
