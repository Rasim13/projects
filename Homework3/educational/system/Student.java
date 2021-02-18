package educational.system;

public class Student {
    private String fullName;
    private int age;
    private String groupName;
    private CourseScore[] courses;

    public Student(String fullName, int age, String groupName, CourseScore[] courses) {
        this.fullName = fullName;
        this.age = age;
        this.groupName = groupName;
        this.courses = courses;
    }

    public Student(String fullName, int age, String groupName) {
        this(fullName,age,groupName,new CourseScore[100]);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public CourseScore[] getCourses() {
        return courses;
    }

    public void setCourses(CourseScore[] courses) {
        this.courses = courses;
    }
}
