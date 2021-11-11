package example1;

public class Main {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Hello");
        printable.print();
    }
}
