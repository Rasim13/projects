import java.util.Scanner;

class Program5 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long count = 0;

        if(N > 0){
            for (int i = 1; i <= N; i++) {
                count += i;
            }
        System.out.println(count);    
        } else {
            System.out.println("FAILED");
        }
       
    }    
}