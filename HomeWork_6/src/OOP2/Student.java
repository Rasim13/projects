package OOP2;

public class Student {
    private String name;
    private String initials;
    private int group;
    private int grades[];
    private int nGrades;

    public Student(String name, String initials, int group) {
        this.name = name;
        this.initials = initials;
        this.grades = new int[5];
        this.nGrades = 0;
    }

    public boolean addGrade(int grade) {
        if (nGrades >= 5) {
            return false;
        }
        grades[nGrades] = grade;
        nGrades++;
        return true;
    }

    public boolean isGood() {
        for (int i = 0; i < nGrades; ++i) {
            if (grades[i] != 9 && grades[i] != 10) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.print(name + " " + initials);
        System.out.print(". Group: " + Integer.toString(group) + ". Grades: ");
        for (int i = 0; i < nGrades; ++i) {
            System.out.print(Integer.toString(grades[i]) + " ");
        }
        System.out.print("\n");
    }
}
