import java.util.Scanner;

public class TaskArrayExtra6 {
    static Scanner scanner = new Scanner(System.in);

    //Сумма цифр массива

    public static void main(String[] args) {
        int[] fillArray = getArray();
        int sumNumbers = getSumNumbersArray(fillArray);
        System.out.println(sumNumbers);
    }

    public static int getSumNumbersArray(int[] fillArray) {
        int sum = 0;
        for (int i = 0; i < fillArray.length; i++){
            while(fillArray[i] != 0){
                sum += +fillArray[i] % 10;
                fillArray[i] = fillArray[i] / 10;
            }
        }
        return sum;
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
