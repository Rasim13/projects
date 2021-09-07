package ru.itis.Example2;

public class ThreadByRunnable implements Runnable{

    private Thread thread;
    private String threadName;

    public ThreadByRunnable(String threadName) {
        this.threadName = threadName;
        System.out.println("Thread " + threadName + " created successfully");
    }


    @Override
    public void run() {
        System.out.println("Thread " + threadName + " is running...");

        try {

            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + threadName + " " + i);
                Thread.sleep(100);
                }

            } catch (InterruptedException e) {
            System.out.println("Thread " + threadName +  " interrupted.");
        }

        System.out.println("Leaving thread " + threadName);

    }

    public void start() {
        System.out.println("Thread " + threadName + " is started successfully.");
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
