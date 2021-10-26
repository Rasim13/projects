package multithreading.example4;

public class Main4 {
    public static void main(String[] args) {
//
//        for (int i = 5; i > 0 ; i--) {
//            System.out.println(i);
//            Thread.sleep(1000);
//        }
//        System.out.println("Поехали !!!");

        Thread thread1 = new Thread(new MyRunnable());
        MyThread myThread = new MyThread();
        thread1.start();
        myThread.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {

        }
        try {
            myThread.join();
        } catch (InterruptedException e) {

        }

        System.out.println("The end!!!");
    }
}
