package ru.itis;

public class Main {

    public static void main(String[] args) throws Exception{
        EggThread eggThread = new EggThread();
        eggThread.start();
        HenThread henThread = new HenThread();
        henThread.start();

        // если мы в потоке х вызываем join() над потоком y
        // то х будет ждать, пока полностью не выполнится поток y
        eggThread.join();
        henThread.join();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " Human");
            }
        };

        Thread thread = new Thread(task);
        thread.start();


    }
}
