package ru.itis.game.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.game.dto.MessageDto;
import ru.itis.game.dto.UsernamePasswordDto;
import ru.itis.game.services.GameService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    // выделим отдельный класс под каждого клиента
    class Client extends Thread {
        // номер клиента
        private int clientNumber;
        // поток байтов для чтения информации от клиента
        private BufferedReader fromClient;
        // поток байтов для записи информации клиенту
        private PrintWriter toClient;
        // флаг, аутентифицирован ли пользователь (мы знаем, кто это)
        private boolean isAuthenticated = false;
        // флаг, который говорит, подключен ли клиент
        private boolean isConnected = true;
        // объект, который представляет из себя непосредственно подключение
        private Socket client;
        // конструктор клиента
        public Client(Socket socket, int clientNumber) {
            // даем потоку название номера клиента
            super(String.valueOf(clientNumber));
            // запоминаем подключение
            this.client = socket;
            // фиксируем номер
            this.clientNumber = clientNumber;
            // отркываем потоки для чтения и записи информации
            initializeClientStreams(socket);
        }

        private void initializeClientStreams(Socket client) {
            try {
                // сюда читаем от клиента
                InputStream fromClientInputStream = client.getInputStream();
                // сюда пишем клиенту
                OutputStream toClientOutputStream = client.getOutputStream();

                // использовали Reader и Writer, чтобы обмениваться сообщениями (текстовыми) с клиентами

                this.fromClient = new BufferedReader(new InputStreamReader(fromClientInputStream));
                this.toClient = new PrintWriter(new OutputStreamWriter(toClientOutputStream), true);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public void run() {
            // логика работы отдельного потока для клиента
            System.out.println("СЕРВЕРНЫЙ ПОТОК " + clientNumber + " поток для клиента запущен");
            // сначала проходим этап аутентификации
            processAuthentication();
            // проходим этап обработки собощений
            processMessages();
            // закрыть соединение
            closeClient();
        }

        private void processAuthentication() {
            // пока пользователь не аутентифицирован
            while (!isAuthenticated) {
                try {
                    // читаю от клиента сообщение - это строка в формате JSON
                    String authenticationMessage = fromClient.readLine();

                    if (authenticationMessage != null) {
                        // преобразую строку JSON в конкретный объект UsernamePasswordDto
                        UsernamePasswordDto usernamePasswordDto = objectMapper.readValue(authenticationMessage, UsernamePasswordDto.class);

                        // если это был запрос на регистрацию
                        if (usernamePasswordDto.getType().equals("signUp")) {
                            gameService.signUp(usernamePasswordDto);
                        }
                        // если аутентификация прошла успешно
                        // выполняем аутентификацию
                        if (gameService.authenticate(usernamePasswordDto)) {
                            // ставлю флаг аутентификации
                            isAuthenticated = true;
                        } else {
                            // если аутентификация не выполнилась - убираю флаг подключения
                            isConnected = false;
                            break;
                        }
                    }
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        // обработка сообщений
        private void processMessages() {
            // пока есть подключение
            while (isConnected) {
                try {
                    // считываем от клиента сообщение
                    String messageFromClient = fromClient.readLine();
                    // из JSON -строки преобразуем его в полноценный объект
                    MessageDto message = objectMapper.readValue(messageFromClient, MessageDto.class);
                    // сохраняем в базу данных это сообщение
                    gameService.saveMessage(message);
                    // пробегаем по списку всех клиентов
                    for (Client client : clients) {
                        // если клиент из списка - это не я сам и если клиент аутентифицирован
                        if (this != client && client.isAuthenticated) {
                            // отправка сообщения этому клиенту
                            client.toClient.println(messageFromClient);
                        }
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

        // закрытие клиента
        private void closeClient() {
            // удаляем из списка подключений
            clients.remove(this);
            try {
                // закрываем соединение
                client.close();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
    // сервер, объектная переменная, через которую будет общаться наш сервер
    private ServerSocket server;

    // список клиентов, для каждого клиента создаем отдельный поток исполнения, который привязывается к клиенту
    private List<Client> clients;
    // бизнес-логика нашего приложения
    @Autowired
    private GameService gameService;
    // для конвертации сообщений из JSON в объект и наоборот
    @Autowired
    private ObjectMapper objectMapper;
    // запускает сервер
    public void start(int port) {
        try {
            // создаем пустой список клиентов
            clients = new ArrayList<>();
            // запускаем сокет-сервер
            server = new ServerSocket(port);
            // создаем отдельный поток для ожидания клиентов
            new Thread(() -> {
                // запускаем бесконечный цикл (потому что клиентов может быть много и мы ждем каждого)
                while (true) {
                    try {
                        // дождались клиента
                        // accept не дает приложению отработать дальше, пока не подключится новый клиент
                        Socket socket = server.accept();
                        // создаем для него объект
                        Client client = new Client(socket, clients.size());
                        // запустили поток для получения сообщений от конкретного клиента
                        client.start();
                        // поток кладем в общий список
                        clients.add(client);
                        gameService.connect(socket.getRemoteSocketAddress().toString());
                        System.out.println("СЕРВЕРНЫЙ ПОТОК - " + Thread.currentThread().getName() + " КЛИЕНТ ПОДКЛЮЧЕН");
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }, "connectClientsThread").start();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
