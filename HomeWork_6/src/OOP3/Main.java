package OOP3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        for (int i = 0; i < number ; i++) {
            Phone.createObject("Samsung " + i);
        }

        System.out.println("Created are " + Phone.count + " objects");
    }
}
