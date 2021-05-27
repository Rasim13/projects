package ru.itis.game.services;

import ru.itis.game.dto.MessageDto;
import ru.itis.game.dto.UsernamePasswordDto;

public interface GameService {

    void connect(String ip);

    void saveMessage(MessageDto message);

    boolean authenticate(UsernamePasswordDto usernamePassword);

    Long startGame(String firstPlayer, String secondPlayer);

    boolean shot(Long gameId, String shooterNickname, String targetNickname);

    void finishGame(Long gameId);

    void signUp(UsernamePasswordDto usernamePasswordDto);
}
