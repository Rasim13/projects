package multithreading.example5;

public class Main5 {
    public static void main(String[] args) {
        VolatileEx thread = new VolatileEx();
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        System.out.println("After 3 seconds it is time to wake up!");
        thread.b = false;
        try {
            thread.join();
        } catch (InterruptedException e) {

        }

        System.out.println("End of program");

    }
}
