import java.util.Scanner;

class TaskG {
	public static void main(String[] args) {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number = ");
        do{
                number = scanner.nextInt();
        } while(n < 1 || n > 100);

        for(int i = 1; i <= number * number; i++){
            if(i / n == i % n - 1 || i == n * n){
                System.out.print(String.valueOf(i).concat(""))
            }
        }
    }    
}