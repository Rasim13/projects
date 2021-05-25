package ru.itis.game.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.game.models.Player;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class PlayersRepositoryJdbcTemplateImpl implements PlayersRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
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
