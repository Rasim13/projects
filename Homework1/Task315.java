import java.util.Scanner;

public class Task315 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = 0;

        if(number > 0 && number <= 100) {
            
            for(int i = 1; i <= number; i++) {
               
                result += i * i;
            }

            System.out.println(result);

        } else {

            System.out.println("FAILED");
        }
        
    }
}