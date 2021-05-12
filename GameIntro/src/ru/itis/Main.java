package ru.itis;

import ru.itis.repositories.*;
import ru.itis.services.GameService;
import ru.itis.services.GameServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ShotsRepository shotsRepository = new ShotsRepositoryListImpl();
        GamesRepository gamesRepository = new GamesRepositoryFileBasedImpl("games.txt");
        PlayersRepository playersRepository = new PlayersRepositoryMapImpl();
        GameService gameService = new GameServiceImpl(playersRepository, gamesRepository, shotsRepository);
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < 3) {
            String firstPlayer = scanner.nextLine();
            String secondPlayer = scanner.nextLine();
            String gameId = gameService.startGame(firstPlayer,secondPlayer);

            String shooter = firstPlayer;
            String target = secondPlayer;

            int j = 0;
            while (j < 4) {
                System.out.println("Стреляйте " + shooter + " в " + target);
                scanner.nextLine();
                if (gameService.shot(gameId, shooter, target)) {
                    System.out.println("Попали!");
                } else {
                    System.out.println("Не попали!");
                }

                String temp = shooter;
                shooter = target;
                target = temp;
                j++;
            }
            gameService.finishGame(gameId);
            i++;
        }

    }
}
