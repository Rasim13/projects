
public class Main {
    public static void main(String[] args) throws Exception {
        List list = new LinkedList();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(43);
        list.add(25);
        list.add(5);

//        int rsl = list.lastIndexOf(8);
//        System.out.println(rsl);
        list.removeAt(5);

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        LinkedList list1 = new LinkedList();
        list1.add(5);
        list1.add(25);

    }
}
