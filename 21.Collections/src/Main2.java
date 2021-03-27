import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List list1 = new LinkedList<Integer>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(2);
        list1.add(5);
        list1.add(7);

        list1.removeAll(Collections.singleton(2));

        for (Object a: list1) {
            System.out.println(a);
        }
    }
}
