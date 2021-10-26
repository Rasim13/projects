package multithreading.example5;

public class VolatileEx extends Thread {

    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while(b) {
            counter++;
        }

        System.out.println("Loop is finished, counter = " + counter);
    }

}
