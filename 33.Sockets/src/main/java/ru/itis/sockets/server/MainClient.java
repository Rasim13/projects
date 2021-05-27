package ru.itis.sockets.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.itis.sockets.server.dto.MessageDto;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 7777);

            // класс ObjectMapper используется для передачи json формата
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String from = scanner.nextLine();

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

                List<String> tags = null;

                String temp = scanner.nextLine();
                if (messageToServer.contains("#")) {
                    tags = new ArrayList<>();
                    String[] parts = messageToServer.split(" ");
                    for (String part: parts) {
                        if (part.startsWith("@")) {
                            tags.add(part.substring(1));
                        }
                    }
                }

                MessageDto message = MessageDto
                        .builder()
                        .dispatchDateTime(LocalDateTime.now())
                        .text(messageToServer)
                        .from(from)
                        .tags(tags)
                        .build();
                // передает сообщение в формате строки
                toServer.println(objectMapper.writeValueAsString(message));
            }

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
