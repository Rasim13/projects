package ru.itis.game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.game.ApplicationConfig.ApplicationConfig;
import ru.itis.game.server.GameServer;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GameServer gameServer = context.getBean(GameServer.class);
        gameServer.start(7777);
    }
}
