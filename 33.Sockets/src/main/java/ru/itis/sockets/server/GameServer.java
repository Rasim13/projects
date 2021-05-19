package ru.itis.sockets.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GameServer {
    // сервер, объектная переменная, через которую будет общаться наш сервер
    private ServerSocket server;

    private BufferedReader fromClient;
    private PrintWriter toClient;

    public void start(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("SERVER: Сервер запущен");
            System.out.println("SERVER: Ожидаем подключения клиента");
            // данный метод будет ожидать, пока не подключится клиент, и только
            // когда произойдет подключение, программа будет выполняться дальше
            Socket client = server.accept();
            System.out.println("SERVER: Клиент подключен");

           initializeClientStreams(client);

           runMessaging();

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void initializeClientStreams(Socket client) {
        try {
            // сюда читаем от клиента
            InputStream fromClientInputStream = client.getInputStream();
            // сюда пишем клиенту
            OutputStream toClientOutputStream = client.getOutputStream();
            // использовали Reader и Writer, чтобы обмениваться сообщениями (тесктовыми) с клиентами
            this.fromClient = new BufferedReader(new InputStreamReader(fromClientInputStream));
            this.toClient = new PrintWriter(new OutputStreamWriter(toClientOutputStream), true);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void runMessaging() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String message = scanner.nextLine();
                toClient.println(message);
                String messageFromClient = fromClient.readLine();
                System.out.println("От клиента " + messageFromClient);
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

    }
}
