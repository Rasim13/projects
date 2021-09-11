import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = {3, 6, 1, 7, 2, 8, 10, 4, 9, 5};
        countSort(array, array.length);

        for (int h: array) {
            System.out.print(h + " ");
        }

    }

    private static void countSort(int[] array, int length) {
        int min = 0, max = 0;

        for (int i = 1; i < length; i++) {

            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        int range = max - min + 1;

        int[] count = new int[range];

        for (int i = 0; i < length; i++) {

            count[array[i]]++;
        }

        int j = 0;

        for (int i = 0; i < range; i++) {
            for (int k = 0; k < count[i]; k++) {
                array[j] = i;
                j++;
            }
        }
    }
}
