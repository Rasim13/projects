import java.util.Scanner;

public class TaskArrayExtra4 {
    static Scanner scanner = new Scanner(System.in);

    //Среднее арифметическое положительных элементов массива

    public static void main(String[] args) {
        int[] fillArray  = getArray();
        double averageSumPositiveElement = getAverageSum(fillArray);
        System.out.println("result = " + averageSumPositiveElement);
    }

    public static double getAverageSum(int[] fillArray) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < fillArray.length; i++) {
            if(fillArray[i] > 0) {
                sum += fillArray[i];
                count++;
            }
        }
        return sum / count;
    }

    public static int[] getArray(){
        System.out.println("Enter size array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter numbers: ");
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
