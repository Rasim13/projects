package ru.itis.sockets.server;

public class MainServer {
    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start(7777);

    }
}
