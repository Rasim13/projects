import java.util.Arrays;
import java.util.Scanner;

public class TaskArrayBubble {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] totalArray  = getArray();
        System.out.println(Arrays.toString(totalArray));
        int[] sortArray = getSortArray(totalArray);
        System.out.println(Arrays.toString(sortArray));

    }

    public static int[] getSortArray(int[] totalArray) {
        boolean isSorted = false;
        int buf;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < totalArray.length - 1; i++) {
                if(totalArray[i] > totalArray[i + 1]){
                    isSorted = false;
                    buf = totalArray[i];
                    totalArray[i] = totalArray[i + 1];
                    totalArray[i + 1] = buf;
                }
            }
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
