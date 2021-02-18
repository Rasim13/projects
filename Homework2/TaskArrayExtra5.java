import java.util.Arrays;

public class TaskArrayExtra5 {
    //Количество положительных, отрицательных и равных нулю элементов массива
    public static void main(String[] args) {
        int[] fillArray  = getArray();
        int amountPositiveNumbers = getAmountPositiveNumbers(fillArray);
        int amountNegativeNumbers = getAmountNegativeNumbers(fillArray);
        int amountEqualZeroNumbers = getAmountEqualZeroNumbers(fillArray);

        System.out.println(Arrays.toString(fillArray));
        System.out.println("Amount positive elements: " + amountPositiveNumbers);
        System.out.println("Amount negative elements: " + amountNegativeNumbers);
        System.out.println("Amount zero elements: " + amountEqualZeroNumbers);
    }

    private static int getAmountEqualZeroNumbers(int[] fillArray) {
        int countEqualZeroNumbers = 0;

        for (int i = 0; i < fillArray.length; i++) {
            if(fillArray[i] == 0) {
                countEqualZeroNumbers++;
            }
        }
        return countEqualZeroNumbers;
    }

    private static int getAmountNegativeNumbers(int[] fillArray) {
        int countNegativeNumbers = 0;

        for (int i = 0; i < fillArray.length; i++) {
            if(fillArray[i] < 0) {
                countNegativeNumbers++;
            }
        }
        return countNegativeNumbers;
    }

    public static int getAmountPositiveNumbers(int[] fillArray) {
        int countPositiveNumbers = 0;

        for (int i = 0; i < fillArray.length; i++) {
            if(fillArray[i] > 0) {
                countPositiveNumbers++;
            }
        }
        return countPositiveNumbers;
    }

    public static int[] getArray() {
        int start = -5;
        int finish = 4;
        int[] array = new int[20];
        for (int i = 0; i < 20; i++){
            array[i] = start + (int)(Math.random()*((finish - start) + 1));
        }
        return array;
    }
}
