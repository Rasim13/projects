package src.educarional.system;

public class Main {
    public static void main(String[] args) {
        TutorGenerator tutorGenerator = new TutorGenerator();
        CourseGenerator courseGenerator = new CourseGenerator();
        Tutor[] tutors = tutorGenerator.getTutors(20);
        Course[] courses = courseGenerator.getCourses(6);
        CoursePrinter coursePrinter = new CoursePrinter();
        TutorPrinter tutorPrinter = new TutorPrinter();
        tutorPrinter.printTutors(tutors, 3);
        coursePrinter.printCourses(courses,3);
        CourseTutorAutoMatcher courseTutorAutoMatcher = new CourseTutorAutoMatcher();
        courseTutorAutoMatcher.autoMatch(courses, tutors);
        System.out.println("------------------------------------------------------");
        tutorPrinter.printTutors(tutors,3);
        coursePrinter.printCourses(courses,3);
    }
}
