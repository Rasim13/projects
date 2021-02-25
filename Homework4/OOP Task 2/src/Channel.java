
import java.util.Random;

public class Channel {
    private static final int MAX_PROGRAMS_COUNT = 10;
    private String name;
    private Program[] programs;
    private int programsCount = 0;

    private Random random;

    public Channel(String name) {
        this.name = name;
        this.programsCount = 0;
        this.programs = new Program[MAX_PROGRAMS_COUNT];
        this.random = new Random();
    }

    public void addProgram(Program program){
        if(programsCount < MAX_PROGRAMS_COUNT){
            programs[programsCount] = program;
            programsCount++;
        } else {
            System.err.println("Нельзя добавить программму!");
        }

    }

    public void showProgram(){
        System.out.println(name + " программа - ");
        int randomProgramNumber = random.nextInt(programsCount);
        programs[randomProgramNumber].show();
    }
}
