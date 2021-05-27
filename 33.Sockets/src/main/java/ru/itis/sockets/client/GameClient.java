package ru.itis.sockets.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.itis.sockets.dto.MessageDto;
import ru.itis.sockets.dto.UsernamePasswordDto;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GameClient {
    // поток байтов для отправки на сервер
    private PrintWriter toServer;
    // поток байтов, который мы считываем от сервера
    private BufferedReader fromServer;
    // объект для конвертации объектов в JSON и обратно
    private ObjectMapper objectMapper;
    // имя текущего клиента
    private String from;
    // Socket-клиент, основной компонент для взаимодействия с сокет-сервером
    private Socket client;
    // конструктор
    public GameClient(String host, int port) {
        try {
            // создаем подключение к серверу
            this.client = new Socket(host, port);
            // открываем потоки байтов для чтения и записи информации
            this.toServer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
            this.fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // создали объект для конвертации
        objectMapper = new ObjectMapper();
        // регистрируем модуль для конвертации времени/даты в JSON
        objectMapper.registerModule(new JavaTimeModule());
        // запустили прием сообщений с сервера
        startReceive();

    }

    private void startReceive() {
        // запуск отдельного потока исполнения для получения сообщений сервера - слушатель сообщений
        (new ReceiveMessagesTask()).start();
    }

    public void sendAuthentication(String nickname, String password, String type) {
        UsernamePasswordDto usernamePasswordDto = UsernamePasswordDto.builder()
                .nickname(nickname)
                .password(password)
                .type(type)
                .build();

        sendMessageAsJson(usernamePasswordDto);
    }

    // метод для отправки сообщений на сервер
    // отправляется text
    public void sendMessageToServer(String text) {
        // выделяет теги #марсель
        List<String> tags = null;

        if (text.contains("#")) {
            tags = new ArrayList<>();
            String[] parts = text.split(" ");

            for (String part : parts) {
                if (part.startsWith("#")) {
                    tags.add(part.substring(1));
                }
            }
        }
        // создание объекта MessageDto для отправки на сервер
        MessageDto message = MessageDto
                .builder()
                .dispatchDateTime(LocalDateTime.now())
                .text(text)
                .from(from)
                .tags(tags)
                .build();

        sendMessageAsJson(message);
    }

    private void sendMessageAsJson(Object message) {
        try {
            // получаем из объекта JSON-строку
            String messageToServer = objectMapper.writeValueAsString(message);
            // отправка на сервер
            toServer.println(messageToServer);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean isClosed() {
        return client.isClosed();
    }

    public void setFrom(String from) {
        this.from = from;
    }

    // поток для чтения сообщений с сервера
    class ReceiveMessagesTask extends Thread {
        @Override
        public void run() {
            // бесконечно работает
            while (true) {
                try {
                    // читаем сообщение с сервера
                    String messageFromServer = fromServer.readLine();
                    // если оно не null
                    if (messageFromServer != null) {
                        // печатаем сообщение в клиенте
                        System.out.println(messageFromServer);
                    } else {
                        // если сообщение пришло null, то закрываем соединение
                        System.out.println("Поток завершен");
                        client.close();
                        // останавливаем цикл
                        break;
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
            System.out.println("Выход из цикла");
        }
    }

}
