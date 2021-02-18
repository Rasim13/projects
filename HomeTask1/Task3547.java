import java.util.Scanner;

public class Task3547 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if(number > 0 && number <= 9) {
            for(int j = 0; j < number; j++) {
                for (int i = 1 ; i <= j + 1; i++) {
                    System.out.print(i);
                }
                System.out.println();
            }
        } else {
            System.out.println("FAILED");
        }
    }
}