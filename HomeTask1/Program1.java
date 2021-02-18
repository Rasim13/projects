import java.util.Scanner;

class Program1 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digitsSum = 0;
        int count = 0;
        System.out.println("If you want to exit please enter -1");
        System.out.println("Enter number: ");
        int currentNumber = scanner.nextInt();
        while(currentNumber != -1) {
            digitsSum = 0;
            while (currentNumber != 0) {
                digitsSum += +currentNumber % 10;
                currentNumber = currentNumber / 10;
            }
            int x = 2;
            boolean isPrime = true;
            while (x < digitsSum) {
                if (digitsSum % x == 0) {
                    isPrime = false;
                    break;
                }
                x++;
            }
            if (isPrime) {
                count++;
            }
            currentNumber = scanner.nextInt();
        }

        System.out.println("================");
        System.out.println("      " + count);
    }
}