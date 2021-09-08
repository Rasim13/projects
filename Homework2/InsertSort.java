import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 1, 7, 9};
        int[] sortedArray = getSortedArray(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] getSortedArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                array[j] = current;
                j--;
            }
        }
        return array;
    }
}
