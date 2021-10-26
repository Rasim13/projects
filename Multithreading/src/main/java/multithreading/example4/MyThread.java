package multithreading.example4;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " interrupted");
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
