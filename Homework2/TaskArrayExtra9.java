import java.util.Arrays;
import java.util.Scanner;

public class TaskArrayExtra9 {
    static Scanner scanner = new Scanner(System.in);

    //Удаление отрицательных элементов массива

    public static void main(String[] args) {
        int[] totalArray  = getArray();
        System.out.println(Arrays.toString(totalArray));
        int[] resultArray = getRemoveNegativeNumbers(totalArray);
        System.out.println(Arrays.toString(resultArray));
    }

    public static int[] getRemoveNegativeNumbers(int[] totalArray) {
        int[] output = new int[totalArray.length];
        int k = 0;
        for (int array : totalArray) {
            if (array >= 0) {
                output[k++] = array;
            }
        }
        return Arrays.copyOfRange(output,0,k);
    }


    public static int[] getArray() {
        int start = -12;
        int finish = 23;
        System.out.print("Enter size array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = start + (int)(Math.random()*((finish - start) + 1));
        }
        return array;
    }
}
