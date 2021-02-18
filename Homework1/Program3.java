import java.util.Scanner;

class Program3 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if(Math.abs(number) < 10000){

        System.out.println("The next number for the number " + number + " is " + (number + 1));
        System.out.println("The previous number for the number " + number + " is " + (number - 1));
        
        } else {
        	System.out.println("FAILED");
        }
        
    }    
}