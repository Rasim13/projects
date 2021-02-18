import java.util.Arrays;
import java.util.Scanner;

public class TaskArraySelectionSort {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] totalArray  = getArray();
        System.out.println(Arrays.toString(totalArray));
        int[] sortArray = getSelectionSortArray(totalArray);
        System.out.println(Arrays.toString(sortArray));
    }

    public static int[] getSelectionSortArray(int[] totalArray) {
        for (int i = 0; i < totalArray.length; i++) {
            int pos = i;
            int min = totalArray[i];
            for (int j = i + 1; j < totalArray.length; j++) {
                if(totalArray[j] < min){
                    pos = j;
                    min = totalArray[j];
                }
            }
            totalArray[pos] = totalArray[i];
            totalArray[i] = min;

        }
        return totalArray;
    }


    public static int[] getArray() {
        int start = 0;
        int finish = 100;
        System.out.print("Enter size array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = start + (int)(Math.random()*((finish - start) + 1));
        }
        return array;
    }
}
