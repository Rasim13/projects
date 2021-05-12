package example2;

public class Main2 {
    public static void main(String[] args) {
        TestMethod testMethod = new TestMethodStreamAPIImpl();
        testMethod.testFilterAndCount();
        testMethod.testFindFirstSkipCount();
        testMethod.testLimit();


    }
}
