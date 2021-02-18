import java.util.Scanner;

class Program7 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        long N = scanner.nextInt();
        
        long count = 0;
       
        if(N % 2 == 0){
            count = (N / 2) * (N + 1);
              
        } else {
            count = N * (N + 1) / 2;
        } if(N < 0){
            count = -count + 1;
        }
        System.out.println(count);
       
    }    
}