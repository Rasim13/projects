package ru.itis.game.services;

import ru.itis.game.models.Game;
import ru.itis.game.models.Player;
import ru.itis.game.models.Shot;
import ru.itis.game.repositories.GamesRepository;
import ru.itis.game.repositories.PlayersRepository;
import ru.itis.game.repositories.ShotsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

public class GameServiceImpl implements GameService {
    private PlayersRepository playersRepository;
    private GamesRepository gamesRepository;
    private ShotsRepository shotsRepository;
    private GameLogicService gameLogicService;

    public GameServiceImpl(PlayersRepository playersRepository,
                           GamesRepository gamesRepository,
                           ShotsRepository shotsRepository,
                           GameLogicService gameLogicService) {
        this.playersRepository = playersRepository;
        this.gamesRepository = gamesRepository;
        this.shotsRepository = shotsRepository;
        this.gameLogicService = gameLogicService;

    }

    @Override
    public Long startGame(String firstPlayer, String secondPlayer) {
        Player first = getPlayer(firstPlayer);
        Player second = getPlayer(secondPlayer);

        Game game = Game.builder()
                .firstPlayer(first)
                .secondPlayer(second)
                .shotsCount(0)
                .startGameDateTime(LocalDateTime.now())
                .build();

        gamesRepository.save(game);
        return game.getId();
    }

    @Override
    public boolean shot(Long gameId, String shooterNickname, String targetNickname) {
        Optional<Player> shooterOptional = playersRepository.findOneByNickname(shooterNickname);
        Optional<Player> targetOptional = playersRepository.findOneByNickname(targetNickname);

        if (shooterOptional.isPresent() && targetOptional.isPresent() &&
                gameLogicService.isHitTarget(shooterOptional.get().getId(), targetOptional.get().getId())) {


            Optional<Game> gameOptional = gamesRepository.findById(gameId);

            if (gameOptional.isPresent()) {
                Player shooter = shooterOptional.get();
                Player target = targetOptional.get();
                Game game = gameOptional.get();

                Shot shot = Shot.builder()
                        .shooter(shooter)
                        .target(target)
                        .game(game)
                        .build();
                shotsRepository.save(shot);
                shooter.setScore(shooter.getScore() + 1);
                playersRepository.update(shooter);
            }

            return true;
        }
        return false;
    }

    @Override
    public void finishGame(Long gameId) {
        Optional<Game> gameOptional = gamesRepository.findById(gameId);

        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            game.setFinishGameDateTime(LocalDateTime.now());
            gamesRepository.update(game);
        } else {
            throw new IllegalArgumentException("Game not found");
        }
    }

    private Player getPlayer(String nickname) {
        Optional<Player> playerOptional = playersRepository.findOneByNickname(nickname);

        if (playerOptional.isPresent()) {
            return playerOptional.get();
        } else {
            Player player = Player.builder()
                    .nickname(nickname)
                    .build();
            playersRepository.save(player);
            return player;
        }
    }
}
