package ru.itis.sockets.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameServer {
    // выделим отдельный класс под каждого клиента
    class Client extends Thread{
        private int clientNumber;
        private BufferedReader fromClient;
        private PrintWriter toClient;

        public Client(Socket socket, int clientNumber) {
            super(String.valueOf(clientNumber));
            this.clientNumber = clientNumber;
            initializeClientStreams(socket);
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


        @Override
        public void run() {
            System.out.println("СЕРВЕРНЫЙ ПОТОК " + clientNumber + " поток для клиента запущен");
            while (true) {
                try {
                    String messageFromClient = fromClient.readLine();
                    System.out.println("От клиента " + messageFromClient);
                    System.out.println("СЕРВЕРНЫЙ ПОТОК - " + clientNumber + "КЛИЕНТ ПОДКЛЮЧЕН");
                    for (Client client: clients) {
                        if (this != client) {
                            client.toClient.println(messageFromClient);
                        }
                    }
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }

            }
        }
    }

    // сервер, объектная переменная, через которую будет общаться наш сервер
    private ServerSocket server;

    private List<Client> clients;



    public void start(int port) {
        try {
            clients = new ArrayList<>();
            server = new ServerSocket(port);
            new Thread(() -> {
                while (true) {
                    try {
                        // дождались клиента
                        Socket socket = server.accept();
                        // создаем для него объект
                        Client client = new Client(socket, clients.size()  );
                        client.start();
                        clients.add(client);
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }, "connectClientThread").start();

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
