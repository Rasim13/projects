package multithreading.example3;

public class Main3 {
    public static void main(String[] args) {
        Thread5 thread5 = new Thread5();
        // устанавливаем название потока
        thread5.setName("my thread");
        // устанавливаем приоритет потока от 0...10, в данном случае 8
        thread5.setPriority(8);
        // выводим название потока и приоритет потока
        System.out.println("Name of Thread5 = " + thread5.getName() +
                " Priority of Thread5 " + thread5.getPriority());

        Thread5 thread6 = new Thread5();
        System.out.println("Name of Thread6 = " + thread6.getName() +
                " Priority of Thread6 " + thread6.getPriority());
    }
}
