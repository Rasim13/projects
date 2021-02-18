import java.util.Arrays;
import java.util.Scanner;

public class TaskSumMultiplicationArray {
    static Scanner scanner = new Scanner(System.in);

    //Сумма и произведение элементов массива

    public static void main(String[] args) {
        double[] fillArray = getArray();
        double sumElementArray = getSumElementArray(fillArray);
        double multiplicationElementArray = getMultiplicationElementArray(fillArray);
        System.out.println("===== Array =====");
        System.out.println(Arrays.toString(fillArray));
        System.out.println("===== SumElementsArray =====");
        System.out.println("            " + sumElementArray);
        System.out.println("===== MultiplicationElementArray =====");
        System.out.println("            " + multiplicationElementArray);
    }

    private static double getMultiplicationElementArray(double[] fillArray) {
        int multiplication = 0;
        for (int i = 0; i < fillArray.length; i++) {
            multiplication += fillArray[i];
        }
        return multiplication;
    }

    private static double getSumElementArray(double[] fillArray) {
        int sum = 0;
        for (int i = 0; i < fillArray.length; i++) {
            sum += fillArray[i];
        }
        return sum;
    }

    public static double[] getArray() {
        System.out.println("Enter size array: ");
        int size = scanner.nextInt();
        double[] array = new double[size];
        System.out.println("Enter numbers: ");
        for (int i = 0; i < array.length; i++){
            array[i] = scanner.nextDouble();
        }
        return array;
    }
}
