package multithreading.example2;

public class Thread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println(i);
        }
    }
}
