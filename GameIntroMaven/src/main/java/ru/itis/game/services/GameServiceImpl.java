package ru.itis.game.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.game.dto.MessageDto;
import ru.itis.game.dto.UsernamePasswordDto;
import ru.itis.game.models.*;
import ru.itis.game.repositories.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Component(value = "gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private PlayersRepository playersRepository;
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private ShotsRepository shotsRepository;
    @Autowired
    private GameLogicService gameLogicService;
    @Autowired
    private MessagesRepository messagesRepository;
    @Autowired
    private ClientsRepository clientsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void connect(String ip) {
        Client client = Client.builder()
                .dateTime(LocalDateTime.now())
                .ip(ip)
                .build();
        clientsRepository.save(client);

    }

    @Override
    public void saveMessage(MessageDto message) {
        Message model = Message.builder()
                .dateTime(message.getDispatchDateTime())
                .tags(message.getTags())
                .text(message.getText())
                .build();
        messagesRepository.save(model);
    }

    @Override
    public boolean authenticate(UsernamePasswordDto usernamePassword) {
        Optional<Player> playerOptional = playersRepository.findOneByNickname(usernamePassword.getNickname());
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            return passwordEncoder.matches(usernamePassword.getPassword(), player.getPassword());
        } else {
            return false;
        }
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

    @Override
    public void signUp(UsernamePasswordDto usernamePasswordDto) {
        Player player = Player.builder()
                .nickname(usernamePasswordDto.getNickname())
                .password(passwordEncoder.encode(usernamePasswordDto.getPassword()))
                .build();
        playersRepository.save(player);

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
