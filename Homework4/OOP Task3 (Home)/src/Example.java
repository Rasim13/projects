
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] generateArray = {1, 5, 8, 56, 8};
        //addNumberToSequence(87, generateArray);
        removeByIndex(2,generateArray);
    }

    public static void addNumberToSequence(int number, int[] generateArray) {
        int [] newArray = new int[generateArray.length + 1];
        for(int i = 0; i < newArray.length ;i++){
            newArray[i + 1] = generateArray[i];
        }
        newArray[0] = number;
        System.out.println(Arrays.toString(newArray));
    }

    public static void removeByIndex(int index, int[] generateArray) {
        int [] newArray = new int[generateArray.length];
        int size = 0;
        for(int j = 0; j < newArray.length; j++){
                newArray[index] = generateArray[j + 1];
        }
        //Arrays.copyOfRange(newArray,0,count);
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(newArray));
    }
}
