package multithreading.example7;

public class RunnableMobileImpl implements Runnable{
    @Override
    public void run() {
        new Example7().mobileCall();
    }
}
