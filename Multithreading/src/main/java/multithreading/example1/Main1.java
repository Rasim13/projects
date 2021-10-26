package multithreading.example1;

public class Main1 {
    public static void main(String[] args) {
        // Создание потока через класс Thread
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread2.start();
        thread1.start();
    }
}
