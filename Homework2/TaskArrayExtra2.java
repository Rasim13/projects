import java.util.Scanner;

public class TaskArrayExtra2 {
    static Scanner scanner = new Scanner(System.in);

    //Максимальный из элементов массива с четными индексами

    public static void main(String[] args) {
        int[] totalArray  = getArray();
        int maxElement = getMaxElementTotalArray(totalArray);
        System.out.println("result = " + maxElement);
    }

    private static int getMaxElementTotalArray(int[] totalArray) {
        int max = 0;
        for (int i = 0; i < totalArray.length; i++) {
            if(i % 2 == 0)
            {
                if(totalArray[i] > max){
                    max = totalArray[i];
                }
            }
        }
        return max;
    }

    public static int[] getArray(){
        System.out.println("Enter size array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter numbers: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(i + " = ");
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
