import java.util.Scanner;

class Program {
	public static void main(String[] arg) {
		int number = 435678;
		int digitsSum = 0;
		while(number != 0) {
			digitsSum = digitsSum + number % 10;
			number = number / 10;
		}
		System.out.println(digitsSum);
	}
}