import java.util.Scanner;

public class TaskArrayExtra3 {
    static Scanner scanner = new Scanner(System.in);

    //Элементы массива, которые меньше среднего арифметического

    public static void main(String[] args) {
    int[] fillArray  = getArray();
    int averageSum = getAverageSumArray(fillArray);
    showResultArray(fillArray, averageSum);

}

    public static void showResultArray(int[] totalArray, int averageSum) {
        for (int i = 0; i < totalArray.length; i++) {
            if(totalArray[i] < averageSum) {
                System.out.println("result = " + totalArray[i]);
            }
        }
    }

    public static int getAverageSumArray(int[] totalArray) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < totalArray.length; i++) {
            sum += totalArray[i];
        }
        result = sum / totalArray.length;
        System.out.println("Average Sum -> " + result);
        return result;
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
