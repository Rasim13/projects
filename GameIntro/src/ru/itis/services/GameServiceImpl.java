package ru.itis.services;

import ru.itis.models.Game;
import ru.itis.models.Player;
import ru.itis.models.Shot;
import ru.itis.repositories.GamesRepository;
import ru.itis.repositories.PlayersRepository;
import ru.itis.repositories.ShotsRepository;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class GameServiceImpl implements GameService {
    private PlayersRepository playersRepository;
    private GamesRepository gamesRepository;
    private ShotsRepository shotsRepository;
    private Random random;

    public GameServiceImpl(PlayersRepository playersRepository, GamesRepository gamesRepository, ShotsRepository shotsRepository) {
        this.playersRepository = playersRepository;
        this.gamesRepository = gamesRepository;
        this.shotsRepository = shotsRepository;
        this.random = new Random();
    }

    @Override
    public String startGame(String firstPlayer, String secondPlayer) {
        Player first = getPlayer(firstPlayer);
        Player second = getPlayer(secondPlayer);

        // создали игру с идентификатором
        Game game = new Game(UUID.randomUUID().toString());
        // Задали игре игроков и количество выстрелов + дата вермя начала игры
        game.setFirstPlayer(first);
        game.setSecondPlayer(second);
        game.setShotsCount(0);
        game.setStartGameDateTime(LocalDateTime.now());
        gamesRepository.save(game);
        return game.getId();
    }

    @Override
    public boolean shot(String gameId, String shooterNickname, String targetNickname) {

        int chance = random.nextInt(10);
        if (chance > 4) {
            Player shooter = playersRepository.findOneByNickname(shooterNickname);
            Player target = playersRepository.findOneByNickname(targetNickname);
            Game game = gamesRepository.findOneById(gameId);

            Shot shot = new Shot(game);
            shot.setShooter(shooter);
            shot.setTarget(target);
            shotsRepository.save(shot);

            if (shooter.getScore() == null) {
                shooter.setScore(0);
            }

            shooter.setScore(shooter.getScore() + 1);

            return true;
        }
        return false;
    }

    @Override
    public void finishGame(String gameId) {
        Game game = gamesRepository.findOneById(gameId);
        game.setFinishGameDateTime(LocalDateTime.now());
        gamesRepository.update(game);
    }

    private Player getPlayer(String nickname) {
        Player player;
        if (playersRepository.containsByNickname(nickname)) {
            player = playersRepository.findOneByNickname(nickname);
        } else {
            player = new Player(nickname);
            playersRepository.save(player);
        }
        return player;
    }
}
