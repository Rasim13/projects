import java.util.Scanner;

class Program1.1 {
    static Scanner scanner = new scanner(System.in);
    static Random random = new Random();

	public static void main(String[] args) {
        int n = getInt();
        int[] arr = getRandomArrayForNNumbers(n);
        for(int i : arr){
            System.out.println(i);
        }


    } 

    public static int getInt(){
        return scnner.nextInt();
    }   

    public static int[] getRandomArrayForNNumbers(int n){
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = i * random.nextInt();
        }
        return result;
    }
}