import java.util.Scanner;

class Program4 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstN = scanner.nextInt();
        int secondN = scanner.nextInt();
        int thirdN = scanner.nextInt();

        if(firstN > secondN && firstN > thirdN){

            System.out.println(firstN);

        } else if(secondN > firstN && secondN > thirdN) {
        	
            System.out.println(secondN);
        
        } else {

            System.out.println(thirdN);

        }
        
    }    
}