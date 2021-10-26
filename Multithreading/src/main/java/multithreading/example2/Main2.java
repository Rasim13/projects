package multithreading.example2;

public class Main2 {
    public static void main(String[] args) {
        // Создание потока через интрефейс Runnable
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());

        thread1.start();
        thread2.start();
    }
}
