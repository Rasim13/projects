import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55 ,36};

        System.out.println(arrayToString(array));
        quickSort(array, 0, array.length - 1);


    }

    private static void quickSort(int[] array, int from, int to) {

        if (from < to) {

            //индекс, который разделяет массив на две части. Правая и левая, относительно, которого будет помещены
            // элементы.
            int divideIndex = partition(array, from, to);

            printSortStep(array, from, to, divideIndex);

            // функция вызывает сама себя для первого
            // подмассива сортировки. Границы указывается от начала массива до опорного элемента (не включая его).
            quickSort(array, from, divideIndex - 1);

            quickSort(array, divideIndex, to);
        }

    }
    
    private static void printSortStep(int[] array, int from, int to, int divideIndex) {
        System.out.print(arrayToString(array));
        System.out.print("\npartition at index: " + divideIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(array, from, divideIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(array, divideIndex, to + 1)) + "\n");
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    // функция разделения массива на два подмассива
    private static int partition(int[] array, int from, int to) {

        //создаем переменную, этот указатель ставится на начало массива
        int rightIndex = to;

        // укзатель ставится на конец массива
        int leftIndex = from;
        
        int pivot = array[from + (to - from) / 2];
        
        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            
            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
