package ru.itis.sockets;

import ru.itis.sockets.client.GameClient;

import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        // создаем клиента для сервера
        GameClient gameClient = new GameClient("localhost", 7777);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Хотите ли вы зарегистрироваться?");
        System.out.println("1. Да");
        System.out.println("2. Нет, у меня уже есть аккаунт");
        System.out.println("Введите число");
        int answer = scanner.nextInt();

        String type = answer == 1 ? "signUp" : "signIn";
        scanner.nextLine();
        // считываем имя
        System.out.println("Введите имя:");
        String nickname = scanner.nextLine();
        // считываем пароль
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        gameClient.setFrom(nickname);
        // отправляет информацию об и пароле на сервер
        gameClient.sendAuthentication(nickname, password, type);
        // пока соединение есть
        while (!gameClient.isClosed()) {
            // читаем сообщение из консоли клиента
            String messageToServer = scanner.nextLine();
            // отправляем сообщение на сервер
            gameClient.sendMessageToServer(messageToServer);
        }

        System.out.println("Соединение закрыто.");

    }

}
