import java.util.Random;

// генерирует массив случайных последовательностей
public class SequenceGenerator {
    private Random random;
    private int size;
    private int[] generateArray;

    public SequenceGenerator(int size) {
        this.random = new Random();
        this.size = size;
        this.generateArray = new int[size];
    }

    public  int[] generate(){
        for (int i = 0; i < generateArray.length; i++){
            generateArray[i] = random.nextInt(10);
        }
        return generateArray;
    }
}
