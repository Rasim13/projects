package src.educarional.system;

import java.util.Random;

public class CourseGenerator {
    public static String[] names= {
            "Математика",
            "Физика",
            "Английский",
            "Русский",
            "История",
            "Химия"
    };
    private Random random;

    public CourseGenerator() {
        this.random = new Random();
    }


    public Course[] getCourses(int n){
        Course[] courses = new Course[n];
        if(n > names.length)
            throw new IllegalArgumentException("Can't generate courses.Not enough names");
        for (int i = 0; i < n; i++) {
            courses[i] = getCourse(i);
        }
        return courses;
    }

    private Course getCourse(int i) {
        return new Course(names[i],
                random.nextInt(150));
    }

}
