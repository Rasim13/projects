package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentInfo {

    void testStudents(List<Student> al, Predicate<Student> pr) {
        for (Student s : al) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }

}
    class TestStudent {
        public static void main(String[] args) {
            Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
            Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
            Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
            Student st4 = new Student("Petr", 'm', 35, 4, 7);
            Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

            List<Student> students = new ArrayList<>();
            students.add(st1);
            students.add(st2);
            students.add(st3);
            students.add(st4);
            students.add(st5);

            StudentInfo info = new StudentInfo();

            info.testStudents(students, p ->
                 p.getAvgGrade() > 8);

            System.out.println("--------------------------------");
            info.testStudents(students, (Student s) -> {
                return s.getAge() < 30;
            });
            System.out.println("--------------------------------");
            info.testStudents(students, (Student s) -> {
                return s.getAge() > 20 && s.getAvgGrade() < 9.3 && s.getSex() == 'f';
            });
        }
    }

//interface StudentChek {
//    boolean check(Student s);
//}





