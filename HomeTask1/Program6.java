import java.util.Scanner;

class Program6 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Организуем ввод числа
        long N = scanner.nextInt();
        // Объявляем счетчик
        long count = 0;
        // Проверяем условие, если оно истино вычисляем count и выводим на консоль
        if(N > 0){
            count = (1 + N) * N / 2;
           
        System.out.println(count);    
        } else {
            System.out.println("FAILED");
        }
       
    }    
}