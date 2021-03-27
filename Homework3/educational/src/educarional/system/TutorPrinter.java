package src.educarional.system;

public class TutorPrinter {

    public void printTutors(Tutor[] tutors, int i){
       switch(i){
           case 3:
               for (Tutor tutor : tutors) {
                   printTutorFullInfo(tutor);
               }
               break;
       }
    }

    public void printTutorFullInfo(Tutor tutor){
        System.out.println(tutor.toString());
        System.out.println("Course: " + tutor.getCoursesInfo());
    }
}
