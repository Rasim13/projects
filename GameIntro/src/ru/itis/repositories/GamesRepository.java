package ru.itis.repositories;

import ru.itis.models.Game;

public interface GamesRepository {
    void save(Game game);

    Game findOneById(String gameId);

    void update(Game game);
}
