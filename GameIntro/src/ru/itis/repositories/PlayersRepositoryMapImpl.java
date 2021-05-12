package ru.itis.repositories;

import ru.itis.models.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayersRepositoryMapImpl implements PlayersRepository {
    private Map<String, Player> players;

    public PlayersRepositoryMapImpl() {
        this.players = new HashMap<>();
    }

    @Override
    public void save(Player player) {
        players.put(player.getNickname(), player);

    }

    @Override
    public boolean containsByNickname(String nickname) {
        return players.containsKey(nickname);
    }

    @Override
    public Player findOneByNickname(String nickname) {
        return players.get(nickname);
    }
}
