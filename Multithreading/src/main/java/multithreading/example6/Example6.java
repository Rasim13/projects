package multithreading.example6;

public class Example6 implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Main6.increment();
        }

    }
}
