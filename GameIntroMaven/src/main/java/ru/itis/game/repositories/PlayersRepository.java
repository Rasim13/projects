package ru.itis.game.repositories;

import ru.itis.game.models.Player;

import java.util.Optional;

public interface PlayersRepository extends CrudRepository<Player, Long> {

    Optional<Player> findOneByNickname(String nickname);
}
