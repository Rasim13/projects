package src.educarional.system;

import java.util.Random;

public class CourseTutorAutoMatcher {
    public CourseTutorAutoMatcher(){
        this.random = new Random();
    }
    private Random random;

    public void autoMatch(Course[] courses, Tutor[] tutors) {

        for (Course course: courses) {
            course.setTutor(tutors[random.nextInt(tutors.length)]);
            if (course.getTutor().getCourses() == null){
                Course courseListToSet[] = new Course[courses.length];
                courseListToSet[0] = course;
                course.getTutor().setCourses(courseListToSet);
            } else{
                Course[] courseArray = course.getTutor().getCourses();
                boolean wasSet = false;
                for (int i = 0; i < courseArray.length; i++) {
                    if(courseArray[i] == null){
                        courseArray[i] = course;
                        wasSet = true;
                        break;
                    }
                }
                if (!wasSet){
                    Course[] extendedCourseList = getExtendedCourseList(courseArray);
                    extendedCourseList[courses.length] = course;
                    course.getTutor().setCourses(extendedCourseList);
                }
            }
        }
    }

    private Course[] getExtendedCourseList(Course[] courseArray) {
        Course[] resultExtendedCourseList = new Course[courseArray.length * 2];
        for (int i = 0; i < courseArray.length; i++) {
            resultExtendedCourseList[i] = courseArray[i];

        }
        return resultExtendedCourseList;
    }
}
