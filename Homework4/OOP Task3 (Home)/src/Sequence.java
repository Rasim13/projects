import java.util.Arrays;

public class Sequence {
    //Создаем поля класса Sequence
    private SequenceObserver sequenceObserver;
    private int number;
    private int index;
    private int value;

    public Sequence(int number, int index, int value) {
        this.number = number;
        this.index = index;
        this.value = value;
    }

    public Sequence(SequenceObserver sequenceObserver) {
        this.sequenceObserver = sequenceObserver;
    }

    // 3, 4, 5 -> removeByValue(5) -> 3, 4
    // удалить число из последовательности по значению
    public void removeByValue(int value, int[] generateArray) {
        int [] newArray = new int[generateArray.length - 1];
        int count = 0;
        for (int findNumber:generateArray) {
            if(value == findNumber){
                break;
            }
        }

        for(int j = 0; j < generateArray.length; j++){
            if(generateArray[j] != value){
                newArray[count++] = generateArray[j];
            }
        }
        Arrays.copyOfRange(newArray,0,count);
        System.out.println("------------------------------");
        sequenceObserver.printRemoveByValue(value);
        System.out.println(Arrays.toString(newArray));
    }

    // 3, 4, 5 -> removeByIndex(1) -> 3, 5
    // удалить число из последовательности по индексу
    public void removeByIndex(int index, int[] generateArray) {
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
        System.out.println(Arrays.toString(newArray));
    }

    // добавить число в последовательность
    public void addNumberToSequence(int number, int[] generateArray) {
        int [] newArray = new int[generateArray.length + 1];
        for(int i = 0; i < newArray.length - 1; i++){
            newArray[i + 1] = generateArray[i];
        }
        newArray[0] = number;
        System.out.println("------------------------------");
        sequenceObserver.printAddNumber(number);
        System.out.println(Arrays.toString(newArray));
    }

    // вставить элемент со сдвигом всех остальных - insert()
    public void insertNumberToSequence(int index, int number, int[] generateArray) {
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
        System.out.println(Arrays.toString(newArray));
    }

    // получить элемент по индексу
    public void getNumberByIndex(int index, int[] generateArray) {
        int findNumber = -1;
        for(int j = 0; j < generateArray.length; j++){
            if(j == index){
                findNumber = generateArray[j];
                break;
            }
        }
        System.out.println("------------------------------");
        sequenceObserver.printNumberGetByIndex(index);
        System.out.println(findNumber);
    }

    // вставить элемент в индекс - replace()
    public void replaceNumberToSequence(int index, int number, int[] generateArray) {
        int findNumber = -1;
        for(int j = 0; j < generateArray.length; j++){
            if(j == index){
                generateArray[j] = number;
                break;
            }
        }
        System.out.println("------------------------------");
        sequenceObserver.printReplaceNumber(index, number);
        System.out.println(Arrays.toString(generateArray));
    }

}

