package ru.itis.repositories;

import ru.itis.models.Player;

public interface PlayersRepository {
    void save(Player player);
    boolean containsByNickname(String nickname);
    Player findOneByNickname(String firstPlayer);
}
