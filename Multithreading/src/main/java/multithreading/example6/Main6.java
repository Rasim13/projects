package multithreading.example6;

public class Main6 {

    volatile static int counter = 0;
    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Example6());
        Thread thread2 = new Thread(new Example6());

        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {

        }
        try {
            thread2.join();
        } catch (InterruptedException e) {

        }

        System.out.println(counter);
    }
}
