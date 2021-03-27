package expression;

public class Main {
    public static void main(String[] args) {
        TwoNumbersProcessFunction sum = (first, second) -> first + second;

        System.out.println(sum.process(45,56));
    }
}
