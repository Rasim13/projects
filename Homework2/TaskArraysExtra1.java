import java.util.Scanner;

public class TaskArraysExtra1 {
    static Scanner scanner = new Scanner(System.in);

    //Сумма четных положительных элементов массива

    public static void main(String[] args) {
        int[] totalArray= getArray();
        int sumPositiveEven = getSum(totalArray);
        if(sumPositiveEven > 0) {
            System.out.println("result = " + sumPositiveEven);
        } else {
            System.out.println("FAILED");
        }
    }

    public static int getSum(int[] totalArray) {
        int resultSum = 0;
        for (int i = 0; i < totalArray.length; i++) {
            if(totalArray[i] > 0 && totalArray[i] % 2 == 0){
                resultSum += totalArray[i];
            }
        }
        return resultSum;
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
