package multithreading.example7;

public class Main7 {
    public static void main(String[] args) {
        Thread threadMobile = new Thread(new RunnableMobileImpl());
        Thread threadSkype = new Thread(new RunnableSkypeImpl());
        Thread threadWhatsapp = new Thread(new RunnableWhatsappImpl());
        threadMobile.start();
        threadSkype.start();
        threadWhatsapp.start();

    }
}
