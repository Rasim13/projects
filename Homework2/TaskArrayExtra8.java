import java.util.Scanner;
import java.util.Arrays;

public class TaskArrayExtra8 {
    static Scanner scanner = new Scanner(System.in);

    //Найти два наименьших (минимальных) элемента массива

    public static void main(String[] args) {
        int[] totalArray  = getArray();
        System.out.println(Arrays.toString(totalArray));
        int[] sortArray = getSortArray(totalArray);
        int[] resultArray = Arrays.copyOf(sortArray,2);
        System.out.println(Arrays.toString(resultArray));

    }

    public static int[] getSortArray(int[] totalArray) {
        Arrays.sort(totalArray);
        return totalArray;
    }

    public static int[] getArray() {
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
