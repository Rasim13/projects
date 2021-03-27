public class Main {
	public static void main(String[] args) {
		SequenceGenerator generator = new SequenceGenerator();
		Sequence sequence = generator.generate(6);

//		sequence.replaceNumberToSequence(1,78);
//		sequence.addNumberToSequence(23);
//		sequence.getNumberByIndex(5);
//		sequence.insertNumberToSequence(4,36);
//		sequence.removeByIndex(3);
		sequence.removeByValue(2);
	}
}

