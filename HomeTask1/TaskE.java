import java.util.Scanner;

class TaskE {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aNumber = scanner.nextInt();
        int bNumber = scanner.nextInt();
        int cNumber = scanner.nextInt();

        if(Math.abs(aNumber) < 10000 && Math.abs(bNumber) < 10000 && Math.abs(cNumber) < 10000){
            if(aNumber % 2 == 0 && bNumber != 0){
                System.out.println("Yes");
            } else if(aNumber % 2 == 0 && cNumber != 0){
                System.out.println("Yes");
            }else if(bNumber % 2 == 0 && aNumber != 0){
                System.out.println("Yes");
            }else if(bNumber % 2 == 0 && cNumber != 0){
                System.out.println("Yes");
            }else if(cNumber % 2 == 0 && aNumber != 0){
                System.out.println("Yes");
            }else if(cNumber % 2 == 0 && bNumber != 0){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }    
}