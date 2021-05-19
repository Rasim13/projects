package ru.itis.game.services;

public interface GameService {
    Long startGame(String firstPlayer, String secondPlayer);
    boolean shot(Long gameId, String shooterNickname, String targetNickname);
    void finishGame(Long gameId);
}
