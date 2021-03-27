import java.util.Arrays;

public class Sequence {
    //Создаем поля класса Sequence
    private SequenceObserver sequenceObserver;
    private SequenceResult sequenceResult;
    private int[] generateArray;

    public Sequence(int[] generateArray){
        this.generateArray = generateArray;
        this.sequenceResult = new SequenceResult();
        this.sequenceObserver = new SequenceObserver();
    }

    // 3, 4, 5 -> removeByValue(5) -> 3, 4
    // удалить число из последовательности по значению

    public void removeByValue(int value) {
        int [] newArray = new int[generateArray.length - 1];
        int count = 0;
        for(int i = 0; i < generateArray.length; i++){
            if(generateArray[i] == value){
                for(int j = 0; j < generateArray.length; j++){
                    if(generateArray[j] != value){
                        newArray[count++] = generateArray[j];
                    }
                }
                Arrays.copyOfRange(newArray,0,count);
                System.out.println("------------------------------");
                sequenceObserver.printRemoveByValue(value);
                sequenceResult.showResultRemoveValue(newArray);
                return;
            }
        }
        sequenceResult.showNotValueByArray();
    }

    // 3, 4, 5 -> removeByIndex(1) -> 3, 5
    // удалить число из последовательности по индексу
    public void removeByIndex(int index) {
        int [] newArray = new int[generateArray.length - 1];
        int count = 0;
        for(int j = 0; j < generateArray.length; j++){
            if(j != index){
                newArray[count++] = generateArray[j];
            }
        }
        Arrays.copyOfRange(newArray,0,count);
        System.out.println("------------------------------");
        sequenceObserver.printRemoveByIndex(index);
        sequenceResult.showResultRemoveIndex(newArray);
    }

    // добавить число в последовательность
    public void addNumberToSequence(int number) {
        int [] newArray = new int[generateArray.length + 1];
        for(int i = 0; i < newArray.length - 1; i++){
            newArray[i + 1] = generateArray[i];
        }
        newArray[0] = number;
        System.out.println("------------------------------");
        sequenceObserver.printAddNumber(number);
        sequenceResult.showResultAddNumber(newArray);
    }

    // вставить элемент со сдвигом всех остальных - insert()
    public void insertNumberToSequence(int index, int number) {
        int [] newArray = new int[generateArray.length + 1];
        for(int i = 0; i < newArray.length - 1; i++){
            if(i < index) {
                newArray[i] = generateArray[i];
            } else {
                newArray[i + 1] = generateArray[i];
            }
        }
        newArray[index] = number;
        System.out.println("------------------------------");
        sequenceObserver.printInsertNumber(index, number);
        sequenceResult.showResultInsertNumber(newArray);
    }

    // получить элемент по индексу
    public void getNumberByIndex(int index) {
        int findNumber = -1;
        for(int j = 0; j < generateArray.length; j++){
            if(j == index){
                findNumber = generateArray[j];
                break;
            }
        }
        System.out.println("------------------------------");
        sequenceObserver.printNumberGetByIndex(index);
        sequenceResult.showResultNumberByIndex(findNumber);
    }

    // вставить элемент в индекс - replace()
    public void replaceNumberToSequence(int index, int number) {
        for(int j = 0; j < generateArray.length; j++){
            if(j == index){
                generateArray[j] = number;
                break;
            }
        }
        System.out.println("------------------------------");
        sequenceObserver.printReplaceNumber(index, number);
        sequenceResult.showResultReplaceNumber(generateArray);
    }
}

