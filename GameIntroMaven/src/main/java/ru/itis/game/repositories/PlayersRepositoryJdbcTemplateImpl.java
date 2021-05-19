package ru.itis.game.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.game.models.Player;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class PlayersRepositoryJdbcTemplateImpl implements PlayersRepository {

    private JdbcTemplate jdbcTemplate;

    public PlayersRepositoryJdbcTemplateImpl (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Player> findAll() {
        return null;
    }

    @Override
    public Optional<Player> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Player account) {

    }

    @Override
    public void update(Player account) {

    }

    @Override
    public void delete(Player account) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Player> findOneByNickname(String nickname) {
        return Optional.empty();
    }
}
