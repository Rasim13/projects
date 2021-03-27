
public class Main {
    public static void main(String[] args) throws Exception {
        List list = new LinkedList();
        list.add(7);
        list.add(15);
        list.add(9);
        list.add(7);
        list.add(1);
        list.add(45);
        list.add(8);

//        int rsl = list.lastIndexOf(8);
//        System.out.println(rsl);
        list.removeAt(5);

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
