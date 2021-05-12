package ru.itis.models;

import java.time.LocalDateTime;

public class Game {
    private String id;
    private LocalDateTime startGameDateTime;
    private LocalDateTime finishGameDateTime;
    private Player firstPlayer;
    private Player secondPlayer;
    //считать количество выстрелов
    private Integer shotsCount;

    public Game(String id) {
        this.id = id;
    }

    public Game() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartGameDateTime() {
        return startGameDateTime;
    }

    public void setStartGameDateTime(LocalDateTime startGameDateTime) {
        this.startGameDateTime = startGameDateTime;
    }

    public LocalDateTime getFinishGameDateTime() {
        return finishGameDateTime;
    }

    public void setFinishGameDateTime(LocalDateTime finishGameDateTime) {
        this.finishGameDateTime = finishGameDateTime;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Integer getShotsCount() {
        return shotsCount;
    }

    public void setShotsCount(Integer shotsCount) {
        this.shotsCount = shotsCount;
    }
}
