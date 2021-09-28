package OOP2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n =10;
        Student students[] = new Student[n];
        students[0] = new Student("Petrov", "A.I", 1);
        students[1] = new Student("Petrov", "B.I.", 1);
        students[2] = new Student("Ivanov", "A.S..", 1);
        students[3] = new Student("Pushkin", "A.S.", 2);
        students[4] = new Student("Dostoevskii", "F.M.", 2);
        students[5] = new Student("Shishkin", "I.I.", 3);
        students[6] = new Student("Aivazovskii", "I.K.", 3);
        students[7] = new Student("Mate", "V.V.", 3);
        students[8] = new Student("Preobrazhenkii", "M.T.", 3);
        students[9] = new Student("Solncev", "F.G.", 3);
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            students[i].addGrade(rnd.nextInt(6) + 5);
            students[i].addGrade(rnd.nextInt(6) + 5);
        }
        System.out.println("все студенты: ");
        for (int i = 0; i < n; ++i) {
            students[i].print();
        }
        System.out.println("хорошие студенты: ");
        for (int i = 0; i < n; ++i) {
            if (students[i].isGood())
                students[i].print();
        }
    }
}
