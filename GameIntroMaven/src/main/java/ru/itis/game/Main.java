package ru.itis.game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.game.ApplicationConfig.ApplicationConfig;
import ru.itis.game.server.GameServer;
import ru.itis.game.services.GameService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GameServer gameServer = context.getBean(GameServer.class);
        gameServer.start(7777);
    }
}
