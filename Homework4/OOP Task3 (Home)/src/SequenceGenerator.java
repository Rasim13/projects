import java.util.Random;

// генерирует массив случайных последовательностей
public class SequenceGenerator {
    private Random random;

    public SequenceGenerator() {
        this.random = new Random();
    }

    public Sequence generate(int size){
        int[] generateArray = new int[size];
        for (int i = 0; i < generateArray.length; i++){
            generateArray[i] = random.nextInt(10);
        }
        return new Sequence(generateArray);
    }
}
