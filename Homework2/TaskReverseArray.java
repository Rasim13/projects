import java.util.Arrays;
import java.util.Scanner;

public class TaskReverseArray {
    static Scanner scanner = new Scanner(System.in);

    //Реверс массива

    public static void main(String[] args) {
        int[] fillArray  = getArray();
        showReverseArray(fillArray);
    }

    public static void showReverseArray(int[] fillArray) {
        int size = fillArray.length;
        for (int i = 0; i < fillArray.length / 2; i++) {
            int temp = fillArray[i];
            fillArray[i] = fillArray[size - 1 - i];
            fillArray[size - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(fillArray));
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
