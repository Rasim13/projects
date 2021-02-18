package educational.system;

public class CoursePrinter {
    public void printCourses(Course[] courses, int i){
        switch(i){
            case 3:
                for (Course course: courses) {
                    printCoursesFullInfo(course);
                }
                break;
        }
    }

    public void printCoursesFullInfo(Course course){
        System.out.println(course.toString());
    }
}
