package OOP3;

public class Phone {

    static int count = 0;

    private String model;

    public Phone(String model) {
        this.model = model;
    }

    public static void createObject(String model) {
        Phone phone = new Phone(model);
        count++;
    }
}
