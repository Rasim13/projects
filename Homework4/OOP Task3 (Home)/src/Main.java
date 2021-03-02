import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
	SequenceGenerator generator = new SequenceGenerator();
	SequenceObserver sequenceObserver = new SequenceObserver();
	Sequence sequence = generator.generate(6);
	Sequence sequence1 = new Sequence(sequenceObserver);


	sequence.replaceNumberToSequence(1,78);
	sequence.addNumberToSequence(23);
	sequence.getNumberByIndex(5);
	sequence.insertNumberToSequence(4,36);
	sequence.removeByIndex(3);
	sequence.removeByValue(1);
    }
}
