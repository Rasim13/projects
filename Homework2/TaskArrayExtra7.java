import java.util.Scanner;

public class TaskArrayExtra7 {
    static Scanner scanner = new Scanner(System.in);

    //Число, чаще всего встречающееся в массиве

    public static void main(String[] args) {
        int[] fillArray = getArray();
        int[] oftenNumber = getNumberOftenMet(fillArray);
        showOftenNumber(oftenNumber,fillArray);
    }

    public static void showOftenNumber(int[] oftenNumber,int[] fillArray) {
        int max = 0;
        for (int i = 0; i < fillArray.length - 1; i++) {
            if(oftenNumber[i] > max){
                max = oftenNumber[i];
            }
        }
        System.out.println("Самое повторяющееся число: " + oftenNumber[max] + "\n" +
                "Число повторов: " + max + " раз");
    }

    public static int[] getNumberOftenMet(int[] fillArray) {
        int[] a = new int[fillArray.length];
        for (int i = 0; i < fillArray.length; i++) {
            for (int j = 0; j < fillArray.length; j++) {
                if(fillArray[i] == fillArray[j]){
                    a[i]++;
                }
            }
        }
        return a;
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
