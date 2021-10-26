package multithreading.example2;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 100; i > 0; i--) {
            System.out.println(i);
        }
    }
}
