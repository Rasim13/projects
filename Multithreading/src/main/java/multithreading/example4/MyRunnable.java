package multithreading.example4;

import multithreading.example3.Thread5;

public class MyRunnable implements Runnable{
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
