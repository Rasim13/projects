import java.util.Scanner;

class Program8 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int N = scanner.nextInt();
        
        if(N > 0){
            if(5 <= N && N <= 20 || N >= 25 && N <= 30){
                System.out.println(N + " bochek");
            } else if (N == 1) {
                System.out.println(N + " bocheka");

            }else if (N % 2 == 0 || N % 3 == 1){
                System.out.println(N + " bocheki");
            } else if(N == 2 || N == 3 || N == 4) {
                System.out.println(N + " bocheki");
            }
        }  
    }    
}