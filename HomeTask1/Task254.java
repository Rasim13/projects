import java.util.Scanner;

class Task254 {
	public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       int x1 = scanner.nextInt();
       int y1 = scanner.nextInt();
       int x2 = scanner.nextInt();
       int y2 = scanner.nextInt();

       if(x1 >= 1 && x1 <= 8 && x2 >= 1 && x2 <= 8 && y1 >= 1 && y1 <= 8 && y2 >= 1 && y2 <= 8) {
        if(x1 == x2 || y1 == y2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
       
       }
    
    }    
}       
