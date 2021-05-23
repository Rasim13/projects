package ru.itis.sockets.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 7777);
            Scanner scanner = new Scanner(System.in);

            PrintWriter toServer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            new Thread(() -> {
                while(true) {
                    String messageFromServer = null;
                    try {
                        messageFromServer = fromServer.readLine();
                        System.out.println(messageFromServer);
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }).start();

            while(true) {
                String messageToServer = scanner.nextLine();
                toServer.println(messageToServer);
            }

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
