package src.educarional.system;

import java.util.Arrays;

public class Course {
    private String name;
    private int hours;
    private Tutor tutor;
    private Student[] students;

    public Course(String name, int hours, Tutor tutor, Student[] students) {
        this.name = name;
        this.hours = hours;
        this.tutor = tutor;
        this.students = students;
    }

    public Course(String name, int hours, Tutor tutor) {
        this(name, hours, tutor, null);
    }

    public Course(String name, int hours) {
        this(name, hours, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", tutor=" + tutor +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public String getStudentInfo() {
        if(students == null) return null;
        String result = "";
        for(Student student: students){

        }
        return result;
    }
}
