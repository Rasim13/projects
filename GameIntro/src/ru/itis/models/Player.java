package ru.itis.models;

public class Player {
    private String nickname;
    private Integer score;
    private Integer winsCount;
    private Integer losesCount;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(Integer winsCount) {
        this.winsCount = winsCount;
    }

    public Integer getLosesCount() {
        return losesCount;
    }

    public void setLosesCount(Integer losesCount) {
        this.losesCount = losesCount;
    }
}
