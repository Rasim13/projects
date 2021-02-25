import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
	SequenceGenerator generator = new SequenceGenerator(6);
	int[] numbers = generator.generate();
	System.out.println(Arrays.toString(numbers));
	Sequence sequence = new Sequence();
	sequence.replaceNumberToSequence(1,78,numbers);
	sequence.addNumberToSequence(23,numbers);
	sequence.getNumberByIndex(5,numbers);
	sequence.insertNumberToSequence(4,36,numbers);
	sequence.removeByIndex(3,numbers);
	sequence.removeByValue(1,numbers);

    }
}
