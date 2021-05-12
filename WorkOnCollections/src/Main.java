import java.util.*;

public class Main {
    public static void main(String[] args) {
        testTimeOfDifferentListImplementations();
    }

    public static void testTimeOfDifferentListImplementations() {
        int size = 1000000;
        int attemptCount = 100000;
        List<Integer> integerArrayList = new ArrayList<>();
        List<Integer> integerLinkedList = new LinkedList<>();
        int[] array = new int[size];
        Set<Integer> integerHashSet = new HashSet<>();

        Random random = new Random();
        // Заполнение коллекций и массива случайными числами
        for (int i = 0; i < size; i++) {
            integerArrayList.add(random.nextInt(size));
            integerLinkedList.add(random.nextInt(size));
            array[i] = random.nextInt(size);
            integerHashSet.add(random.nextInt(size));
        }

        long timeStart = System.nanoTime();
        long endTime = System.nanoTime();
//        // Метод Get ArrayList
//        for (int i = 0; i < attemptCount; i++) {
//            integerArrayList.get((int)(Math.random() * (size - 1)));
//        }
//        System.out.println("'Get' for ArrayList " + (endTime - timeStart));
//
//        // Метод Get LinkedList
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            integerLinkedList.get((int)(Math.random() * (size - 1)));
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Get' for LinkedList " + (endTime - timeStart));

//         //Метод contains ArrayList
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            integerArrayList.contains((int)(Math.random() * (size - 1)));
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Contains' for ArrayList " + (endTime - timeStart));
//
//        // Метод contains LinkedList
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            integerLinkedList.contains((int)(Math.random() * (size - 1)));
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Contains' for LinkedList " + (endTime - timeStart));
//
//        // Метод contains HashSet
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            integerHashSet.contains((int)(Math.random() * (size - 1)));
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Contains' for HashSet " + (endTime - timeStart));
//
//        // Метод contains Array
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Contains' for Array " + (endTime - timeStart));

        //Метод Add ArrayList
        timeStart = System.nanoTime();
        integerArrayList.add(85639,340);
        endTime = System.nanoTime();
        System.out.println("'Add' for ArrayList " + (endTime - timeStart));

        //Метод Add LinkedList
        timeStart = System.nanoTime();
        integerLinkedList.add(36457,290);
        endTime = System.nanoTime();
        System.out.println("'Add' for LinkedList " + (endTime - timeStart));

        //Метод Add HashSet
        timeStart = System.nanoTime();
        integerHashSet.add(486);
        endTime = System.nanoTime();
        System.out.println("'Add' for LinkedList " + (endTime - timeStart));

//        // Метод getFirst() (возвращает первый элемент в этом списке) ArrayList
//        timeStart = System.nanoTime();
//        integerArrayList.get(0);
//        endTime = System.nanoTime();
//        System.out.println("'getFirst' for ArrayList " + (endTime - timeStart));
//
//        // Метод getFirst() (возвращает первый элемент в этом списке) LinkedList
//        timeStart = System.nanoTime();
//        integerLinkedList.get(0);
//        endTime = System.nanoTime();
//        System.out.println("'getFirst' for LinkedList " + (endTime - timeStart));
//
//        // Метод getFirst() (возвращает первый элемент в этом списке) HashSet
//        timeStart = System.nanoTime();
//        integerHashSet.iterator().next();
//        endTime = System.nanoTime();
//        System.out.println("'getFirst' for HashSet " + (endTime - timeStart));
//
//        // Метод getFirst() (возвращает первый элемент в этом списке) Array
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            int firstElement = array[0];
//            break;
//        }
//        endTime = System.nanoTime();
//        System.out.println("'getFirst' for Array " + (endTime - timeStart));


//        // метод Remove рандомного значения ArrayList
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            integerArrayList.remove((int)(Math.random() * (size - 1)));
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Remove' for ArrayList " + (endTime - timeStart));
//
//        // метод Remove рандомного значения LinkedList
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            integerLinkedList.remove((int)(Math.random() * (size - 1)));
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Remove' for LinkedList " + (endTime - timeStart));
//
//        // метод Remove рандомного значения hashSet
//        timeStart = System.nanoTime();
//        for (int i = 0; i < attemptCount; i++) {
//            integerHashSet.remove((int)(Math.random() * (size - 1)));
//        }
//        endTime = System.nanoTime();
//        System.out.println("'Remove' for Hashset " + (endTime - timeStart));
    }
}
