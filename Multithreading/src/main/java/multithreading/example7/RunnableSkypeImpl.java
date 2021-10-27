package multithreading.example7;

public class RunnableSkypeImpl implements Runnable{
    @Override
    public void run() {
        new Example7().skypeCall();
    }
}
