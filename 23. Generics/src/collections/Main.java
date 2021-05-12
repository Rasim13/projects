package collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello!");
        strings.add("Rasim");

        String value = strings.get(0);
        System.out.println(value);
    }
}
