package multithreading.example7;

public class RunnableWhatsappImpl implements Runnable{
    @Override
    public void run() {
        new Example7().whatsappCall();
    }
}
