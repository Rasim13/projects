package ru.itis.services;

public interface GameService {
    String startGame(String firstPlayer, String secondPlayer);
    boolean shot(String gameId, String shooterNickname, String targetNickname);
    void finishGame(String gameId);
}
