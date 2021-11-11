package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIf {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        al.add("Hello");
        al.add("Learning Java");
        al.add("Learning Lambda right now");
        al.add("Goodbye");
        // первый вариант записи
//        al.removeIf(element -> element.length() < 6);
        //второй вариант записи
        Predicate<String> p = element -> element.length() < 6;
        al.removeIf(p);
        System.out.println(al);
    }
}
