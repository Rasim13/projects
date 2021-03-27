import java.util.Arrays;

//Выводит результат операции
public class SequenceResult {
    public void showResultAddNumber(int[] newArray){
        System.out.println(Arrays.toString(newArray));
    }

    public void showResultRemoveValue(int[] newArray){
        System.out.println(Arrays.toString(newArray));
    }

    public void showResultRemoveIndex(int[] newArray){
        System.out.println(Arrays.toString(newArray));
    }

    public void showResultInsertNumber(int[] newArray){
        System.out.println(Arrays.toString(newArray));
    }

    public void showResultNumberByIndex(int findNumber){
        System.out.println(findNumber);
    }

    public void showResultReplaceNumber(int[] generateArray){
        System.out.println(Arrays.toString(generateArray));
    }

    public void showNotValueByArray(){
        System.out.println("В массиве нет такого значения");
    }
}
